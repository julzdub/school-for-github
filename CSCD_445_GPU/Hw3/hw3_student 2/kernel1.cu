#include <stdio.h>
#include "kernel1.h"

////////////////////////////////////////////////////////////////////////////////
//! Weighted Jacobi Iteration
//! @param g_dataA  input data in global memory
//! @param g_dataB  output data in global memory
////////////////////////////////////////////////////////////////////////////////
__global__ void k1( float* g_dataA, float* g_dataB, int floatpitch, int width) 
{
    extern __shared__ float s_data[];
    // TODO, implement this kernel below
    
     unsigned int i = blockIdx.y * blockDim.y + threadIdx.y;
    i = i + 1; //because the edge of the data is not processed
  
    // global thread(data) column index
    unsigned int j = blockIdx.x * blockDim.x + threadIdx.x;

    j = j + 1; //because the edge of the data is not processed  


    if( i >= width - 1|| j >= width - 1 || i < 1 || j < 1 ) return;

    int IDX = threadIdx.x;
    int IDY = 1;
    
    ////////////////////////////////////////////////////////////////////////////////
    // For thread 0
    ////////////////////////////////////////////////////////////////////////////////
    if(IDX == 0){
        s_data[IDX] = g_dataA[(i-1) * floatpitch + (j-1)];//Top left
        s_data[(blockDim.x+2)+IDX+1] = g_dataA[ i    * floatpitch + (j-1)];//Left
        s_data[(IDY+1)*(blockDim.x+2)+IDX+1] = g_dataA[(i+1) * floatpitch + (j-1)]; //Bottom left
        s_data[IDX+1] = g_dataA[(i-1) * floatpitch +  j   ]; //Top
        s_data[(blockDim.x+2)+IDX+2] = g_dataA[i * floatpitch + j]; //Itself
        s_data[(IDY+1)*(blockDim.x+2)+IDX+2] = g_dataA[(i+1) * floatpitch +  j   ]; //Bottom   
    }else if(IDX == ((width-2)%blockDim.x)-1 && j == width-2 || IDX == blockDim.x-1){ //<-Boundary check
    ////////////////////////////////////////////////////////////////////////////////
    // For farthest left thread within width
    ////////////////////////////////////////////////////////////////////////////////
        s_data[IDX+2] = g_dataA[(i-1) * floatpitch + (j+1)];//Top right
        s_data[(blockDim.x+2)+IDX+3]  = g_dataA[ i    * floatpitch + (j+1)]; //Right
        s_data[((IDY+1)*(blockDim.x+2))+IDX+3] = g_dataA[(i+1) * floatpitch + (j+1)] ; //Bottom right
        s_data[IDX+1] = g_dataA[(i-1) * floatpitch +  j   ]; //Top
        s_data[(blockDim.x+2)+IDX+2] = g_dataA[i * floatpitch + j]; //Itself
        s_data[(IDY+1)*(blockDim.x+2)+IDX+2] = g_dataA[(i+1) * floatpitch +  j   ]; //Bottom
    }else{
    ////////////////////////////////////////////////////////////////////////////////
    // For all middle threads
    ////////////////////////////////////////////////////////////////////////////////
        s_data[IDX+1] = g_dataA[(i-1) * floatpitch +  j   ]; //Top
        s_data[(blockDim.x+2)+IDX+2] = g_dataA[i * floatpitch + j]; //Itself
        s_data[(IDY+1)*(blockDim.x+2)+IDX+2] = g_dataA[(i+1) * floatpitch +  j   ]; //Bottom
    }
    __syncthreads(); //Make sure all threads move the mem into shared before moving on
    
   
    g_dataB[i * floatpitch + j] = (
                    0.2f * s_data[(blockDim.x+2)+IDX+2] +               //itself
                    0.1f * s_data[IDX+1] +       //N ABOVE
                    0.1f * s_data[IDX+2] +       //NE ABOVE RIGHT
                    0.1f * s_data[(blockDim.x+2)+IDX+3] +       //E RIGHT
                    0.1f * s_data[((IDY+1)*(blockDim.x+2))+IDX+3] +       //SE BOTTOM RIGHT
                    0.1f * s_data[(IDY+1)*(blockDim.x+2)+IDX+2] +       //S BOTTOM
                    0.1f * s_data[(IDY+1)*(blockDim.x+2)+IDX+1] +       //SW BOTTOM LEFT 
                    0.1f * s_data[(blockDim.x+2)+IDX+1] +       //W LEFT 
                    0.1f * s_data[IDX]         //NW TOP LEFT 
                ) * 0.95f;

 



}

