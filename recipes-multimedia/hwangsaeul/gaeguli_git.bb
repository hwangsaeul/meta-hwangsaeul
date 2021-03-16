SUMMARY = "Video Encoding & SRT Streaming library"
DESCRIPTION = "Video Stream over SRT"

HOMEPAGE = "https://github.com/hwangsaeul"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "glib-2.0 glib-2.0-native json-glib libsoup-2.4 libnl \
           srt \
           gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad gstreamer1.0-vaapi \
          "

inherit meson pkgconfig

SRCREV = "1dca553f04773c68d1081fb87fc4d958ba56bea5"
PV = "r1+git${SRCPV}"
S = "${WORKDIR}/git"

SRC_URI = "git://github.com/hwangsaeul/gaeguli;protocol=https;branch=master"
