SUMMARY = "Video Relay library"
DESCRIPTION = "Video Stream Relay over SRT"

HOMEPAGE = "https://github.com/hwangsaeul"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "glib-2.0 glib-2.0-native \
           gaeguli \
          "

inherit meson pkgconfig

SRCREV = "cbcc8c907282722d6aec0c4f155f6c3a3f5a6f5c"
PV = "2.0+git${SRCPV}"
S = "${WORKDIR}/git"

SRC_URI = "git://github.com/hwangsaeul/hwangsae;protocol=https;branch=master"
