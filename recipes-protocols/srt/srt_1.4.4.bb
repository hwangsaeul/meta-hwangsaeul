SUMMARY = "SRT"
DESCRIPTION = "Secure Reliable Transport"
LICENSE = "MPL-2.0"
HOMEPAGE = "https://github.com/Haivision/srt"

LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRC_URI = "git://github.com/Haivision/srt.git;branch=master;protocol=https"

SRCREV = "v1.4.4"

S = "${WORKDIR}/git"

inherit pkgconfig cmake 

DEPENDS = "openssl" 

do_install:prepend() {
  sed -i 's,#!/bin/bash,#!/bin/sh,' ${S}/scripts/srt-ffplay
}
