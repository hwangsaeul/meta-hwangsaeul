SUMMARY = "Realtime video encoder image"

LICENSE = "Apache-2.0"

IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs"

inherit core-image

TOOLCHAIN_HOST_TASK_append = " nativesdk-intltool nativesdk-glib-2.0"
TOOLCHAIN_HOST_TASK_remove_task-populate-sdk-ext = " nativesdk-intltool nativesdk-glib-2.0"

CORE_IMAGE_EXTRA_INSTALL += " \
    iproute2 \
    iproute2-tc \
    intel-microcode \
    igt-gpu-tools \
    procps sudo \
    libva-utils intel-media-driver \
    srt \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-ugly \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-vaapi \
    gstreamer1.0-libav \
    gaeul \
"
