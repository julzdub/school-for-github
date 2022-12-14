#include <stdio.h>
#include <stdlib.h>

void usage()
{
    printf("Usage: ./programName -e eValue file1 file2 \n");

    printf("Usage: ./programName -c cValue\n");
    //-c circleCenterRow circleCenterCol radius oldImageFile newImageFile
    exit(1);
}

int main( int argc, char *argv[] )  
{
   printf("Program name %s\n", argv[0]);
   printf("number of arguments is %d\n", argc);

   int i = 2;
   int eVal = 0;

   int cVal = 0;
   int cVal2 = 0;
   int cVal3 = 0;

   if( ( argc > 1 ) && ( argv[1][0] == '-' ) )
   {
       switch ( argv[1][1] )
       {
           case 'e':
               if( !argv[i] || argc > 5)
                   usage();  //exit program
                puts(argv[i]);
	       eVal = atoi( argv[i] ); //supposed to be eValue
               if ( ! eVal || !argv[i + 1] || !argv[i + 2] )
                   usage();
		
               break;
                
            case 'c':
                if( !argv[i] || argc > 3 )
                    usage();
            puts(argv[i++]);
	        cVal = atoi( argv[i ++] );
            printf("Val %d\n", cVal);
                puts("\n");
                puts(argv[i-1]);
                if( !cVal )
                    usage();
	
        	break;
                
	    default:
		printf("Wrong flag: %s\n", argv[1]);
		usage();
	}
        
    }
    else
    {
        usage();
    }

}