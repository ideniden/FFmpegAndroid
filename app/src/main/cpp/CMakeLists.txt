# Sets the minimum version of CMake required to build the native
# library. You should either keep the default value or only pass a
# value of 3.4.0 or lower.

cmake_minimum_required(VERSION 3.4.1)

# define var
set(lib_src_DIR ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI})
include_directories(
        ${CMAKE_SOURCE_DIR}/include
)

# -----include so
add_library(avcodec-55_lib SHARED IMPORTED)
set_target_properties(avcodec-55_lib PROPERTIES IMPORTED_LOCATION
                             ${lib_src_DIR}/libavcodec-55.so)

add_library(avdevice-55_lib SHARED IMPORTED)
set_target_properties(avdevice-55_lib PROPERTIES IMPORTED_LOCATION
                             ${lib_src_DIR}/libavdevice-55.so)

add_library(avfilter-4_lib SHARED IMPORTED)
set_target_properties(avfilter-4_lib PROPERTIES IMPORTED_LOCATION
                             ${lib_src_DIR}/libavfilter-4.so)

add_library(avformat-55_lib SHARED IMPORTED)
set_target_properties(avformat-55_lib PROPERTIES IMPORTED_LOCATION
                             ${lib_src_DIR}/libavformat-55.so)

add_library(avutil-52_lib SHARED IMPORTED)
set_target_properties(avutil-52_lib PROPERTIES IMPORTED_LOCATION
                             ${lib_src_DIR}/libavutil-52.so)

add_library(ffmpeg_codec_lib SHARED IMPORTED)
set_target_properties(ffmpeg_codec_lib PROPERTIES IMPORTED_LOCATION
                             ${lib_src_DIR}/libffmpeg_codec.so)

add_library(swresample-0_lib SHARED IMPORTED)
set_target_properties(swresample-0_lib PROPERTIES IMPORTED_LOCATION
                             ${lib_src_DIR}/libswresample-0.so)

add_library(swscale-2_lib SHARED IMPORTED)
set_target_properties(swscale-2_lib PROPERTIES IMPORTED_LOCATION
                             ${lib_src_DIR}/libswscale-2.so)

# -----API
add_library( ffmpeg-api
             SHARED
             ffmpeg-api.cpp )

find_library( log-lib
              log )

# -----link
target_link_libraries( ffmpeg-api
                       ${log-lib}
                        android
                        avcodec-55_lib
                        avdevice-55_lib
                        avfilter-4_lib
                        avformat-55_lib
                        avutil-52_lib
                        ffmpeg_codec_lib
                        swresample-0_lib
                        swscale-2_lib)
