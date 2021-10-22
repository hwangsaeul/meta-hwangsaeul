SUMMARY = "Video Relay library"
DESCRIPTION = "Video Stream Relay over SRT"

HOMEPAGE = "https://github.com/hwangsaeul"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "\
    glib-2.0 glib-2.0-native \
    gaeguli \
"

inherit meson pkgconfig

SRCREV = "a09493da0e160007ba38e9fa27f8ab998487cb85"
PV = "2.0+git${SRCPV}"
S = "${WORKDIR}/git"

SRC_URI = "git://github.com/hwangsaeul/hwangsae;protocol=https;branch=master"

PACKAGE_BEFORE_PN = "\
    ${PN}-test \
    ${PN}-recorder \
"
RDEPENDS_${PN}-recorder += "${PN}"
RDEPENDS_${PN}-test += "${PN}"

FILES_${PN}-recorder += "\
    ${libdir}/libhwangsae-dbus-2.0.so.* \
    ${datadir}/dbus-1/* \
    ${datadir}/glib-2.0/schemas/* \
"

FILES_${PN}-test += "\
    ${libdir}/libhwangsae-test-common-2.0.so.* \
"
