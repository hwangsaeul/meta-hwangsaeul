SUMMARY = "SRT"
DESCRIPTION = "Secure Reliable Transport"
LICENSE = "MPL-2.0"
HOMEPAGE = "https://github.com/Haivision/srt"

LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRC_URI = "https://github.com/Haivision/srt/archive/refs/tags/v${PV}.tar.gz"
SRC_URI[sha256sum] = "c06e05664c71d635c37207a2b5a444f2c4a95950a3548402b3e0c524f735b33d"

S = "${WORKDIR}/srt-${PV}"

inherit pkgconfig cmake 

DEPENDS = "openssl" 

do_install_prepend() {
  sed -i 's,#!/bin/bash,#!/bin/sh,' ${S}/scripts/srt-ffplay
}

ERROR_QA_remove_pn-srt = " src-uri-bad"
