cmake_minimum_required(VERSION 3.12)
project(Lab16 C)

set(CMAKE_C_STANDARD 11)

include_directories(linkedList)
include_directories(listUtils)
include_directories(utils)
include_directories(words)

add_executable(Lab16
        linkedList/linkedList.c
        linkedList/linkedList.h
        linkedList/requiredIncludes.h
        listUtils/listUtils.c
        listUtils/listUtils.h
        utils/fileUtils.c
        utils/fileUtils.h
        utils/utils.c
        utils/utils.h
        words/word.c
        words/word.h
        cscd240Lab16.c)
