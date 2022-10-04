cmake_minimum_required(VERSION 3.20)
project(welgejhw1 C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(welgejhw1
        linkedList.c
        linkedList.h
        listUtils.c
        listUtils.h
        main.c
        word.c
        word.h)
