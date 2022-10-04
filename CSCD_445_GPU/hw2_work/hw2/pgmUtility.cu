
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#include "pgmUtility.h"
#include "pgmProcess.h"

// Implement or define each function prototypes listed in pgmUtility.h file.
// NOTE: Please follow the instructions stated in the write-up regarding the interface of the functions.
// NOTE: You might have to change the name of this file into pgmUtility.cu if needed.

__host__ int *pgmRead(char **header, int *numRows, int *numCols, FILE *in){
    int i, j;
    
    // read in header of the image first
    for( i = 0; i < rowsInHeader; i ++)
    {
        if ( header[i] == NULL )
        {
            return NULL;
        }
        if( fgets( header[i], maxSizeHeadRow, in ) == NULL )
        {
            return NULL;
        }
    }

    // extract rows of pixels and columns of pixels
    puts(header[rowsInHeader - 2]);
    sscanf( header[rowsInHeader - 2], "%d %d", numCols, numRows );  // in pgm the first number is # of cols
  
    int *pixels = (int*)malloc((*numCols) * (*numRows) * sizeof(int));

    
    // read in all pixels into the pixels array.

    for( i = 0; i < *numRows; i ++ )
        for( j = 0; j < *numCols; j ++ )
            if(fscanf(in, "%d ", &pixels[(i*(*numCols))+j]) < 0 )
                return NULL;

    
    return pixels;
}

__host__ int pgmDrawCircle( int *pixels, int numRows, int numCols, int centerRow, int centerCol, int radius, char **header ){
    
    int num_bytes = (numCols*numRows*sizeof(int));
    int *d_a;
    cudaMalloc((void**)&d_a, num_bytes);
    cudaMemcpy(d_a, pixels, num_bytes, cudaMemcpyHostToDevice);

    dim3 grid, block;
    block.x = 16;
    block.y = 16;
    grid.x = ceil((float)numCols/block.x);
    grid.y = ceil((float)numRows/block.y);

    pgmDrawCircleK<<<grid, block>>>(d_a, numRows, numCols, centerRow, centerCol, radius);

    cudaMemcpy(pixels, d_a, num_bytes, cudaMemcpyDeviceToHost);

    cudaFree(d_a);

    return 0;
}

__host__ int pgmDrawEdge( int *pixels, int numRows, int numCols, int edgeWidth, char **header ){
    int num_bytes = (numCols*numRows*sizeof(int));
    int *d_a;

    cudaMalloc((void**)&d_a, num_bytes);
    cudaMemcpy(d_a, pixels, num_bytes, cudaMemcpyHostToDevice);

    dim3 grid, block;
    block.x = 16;
    block.y = 16;
    grid.x = ceil((float)numCols/block.x);
    grid.y = ceil((float)numRows/block.y);

    pgmDrawEdgeK<<<grid,block>>>(d_a, numRows, numCols, edgeWidth);

    cudaMemcpy(pixels, d_a, num_bytes, cudaMemcpyDeviceToHost);

    cudaFree(d_a);

    return 0;
}

__host__ int pgmDrawLine( int *pixels, int numRows, int numCols, char **header, int p1row, int p1col, int p2row, int p2col ){
    int num_bytes = (numCols*numRows*sizeof(int));
    int *d_a;

    cudaMalloc((void**)&d_a, num_bytes);
    cudaMemcpy(d_a, pixels, num_bytes, cudaMemcpyHostToDevice);

    dim3 grid, block;
    block.x = 16;
    block.y = 16;
    grid.x = ceil((float)numCols/block.x);
    grid.y = ceil((float)numRows/block.y);

    pgmDrawLineK<<<grid, block>>>(d_a, numRows, numCols, p1row, p1col, p2row, p2col);

    cudaMemcpy(pixels, d_a, num_bytes, cudaMemcpyDeviceToHost);

    cudaFree(d_a);

    return 0;
}

__host__ int pgmWrite( const char **header, const int *pixels, int numRows, int numCols, FILE *out )
{
    int i, j;
    // write the header
    for ( i = 0; i < rowsInHeader; i ++ )
    {
        fprintf(out, "%s", *( header + i ) );
    }
    
    // write the pixels
    for( i = 0; i < numRows; i ++ )
    {
        for ( j = 0; j < numCols; j ++ )
        {
            if ( j < numCols - 1 )
                fprintf(out, "%d ", pixels[(i*numCols)+j]);
            else
                fprintf(out, "%d\n", pixels[(i*numCols)+j]);
        }
    }
    return 0;
}

