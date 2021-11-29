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

SRCREV = "110822e039888b2fcc8a400e6fd20a88dd956fa2"
PV = "1.99+git${SRCPV}"
S = "${WORKDIR}/git"

SRC_URI = "git://github.com/hwangsaeul/gaeguli;protocol=https;branch=master"

PACKAGE_BEFORE_PN += "\
    ${PN}-adaptor-demo \
    ${PN}-test \
    ${PN}-test-dev \
"

FILES:${PN}-adaptor-demo = "\
    ${bindir}/gaeguli-adaptor-demo \
    ${libexecdir}/gaeguli-tc-helper \
"

FILES:${PN}-test = "\
    ${libdir}/libgaeguli-test-common-2.0.so.* \
"

FILES:${PN}-test-dev = "\
    ${includedir}/gaeguli-2.0/gaeguli/test/* \
    ${libdir}/libgaeguli-test-common-2.0.so \
    ${libdir}/pkgconfig/gaeguli-test-common-2.0.pc \
"
