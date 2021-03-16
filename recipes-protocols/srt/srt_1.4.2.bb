SUMMARY = "SRT"
DESCRIPTION = "Secure Reliable Transport"
LICENSE = "MPL-2.0"
HOMEPAGE = "https://github.com/Haivision/srt"

LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

S = "${WORKDIR}/git"

inherit pkgconfig cmake 

SRCREV = "fe6446da4fd9c30e3258dcf3dba05dd627536148"
PV .= "+git${SRCPV}"

SRC_URI = " \
    git://github.com/hwangsaeul/libsrt.git;protocol=https;branch=master \
"

DEPENDS = "openssl" 

do_install_prepend() {
  sed -i 's,#!/bin/bash,#!/bin/sh,' ${S}/scripts/srt-ffplay
}
