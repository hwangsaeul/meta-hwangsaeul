SUMMARY = "Realtime Video Streaming Daemon"
DESCRIPTION = "Bobbling brook"

HOMEPAGE = "https://github.com/hwangsaeul"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "glib-2.0 glib-2.0-native libsoup-2.4 gaeguli hwangsae"

inherit meson pkgconfig useradd systemd gsettings

SRCREV = "e8a6afe6d97720e1a9439e86f8bde8bf862196dd"
PV = "r4+git${SRCPV}"
S = "${WORKDIR}/git"

SRC_URI = " \
    git://github.com/hwangsaeul/gaeul;protocol=https;branch=master \
    file://gaeul2.ini \
"

PACKAGES += "\
    ${PN}-mjpeg \
    ${PN}-relay \
    ${PN}-source \
"

FILES:${PN} = "\
    ${localstatedir}/lib/hwangsaeul/gaeul2/conf/gaeul2.ini \
    ${libdir}/libgaeul-2.0.so.* \
    ${sysconfdir}/default \
    ${sysconfdir}/gaeul2 \
"

FILES:${PN}-mjpeg = "\
    ${bindir}/gaeul2-mjpeg-agent \
    ${libdir}/libgaeul-mjpeg-2.0.so.* \
    ${datadir}/dbus-1/system.d/org.hwangsaeul.Gaeul2.MJPEG.conf \
    ${datadir}/glib-2.0/schemas/org.hwangsaeul.Gaeul2.MJPEG.gschema.xml \
"

FILES:${PN}-source = "\
    ${bindir}/gaeul2-source-agent \
    ${bindir}/gaeul-source-push-text \
    ${libdir}/libgaeul-source-2.0.so.* \
    ${datadir}/dbus-1/system.d/org.hwangsaeul.Gaeul2.Source.conf \
    ${datadir}/glib-2.0/schemas/org.hwangsaeul.Gaeul2.Source.gschema.xml \
    ${systemd_unitdir} \
"

FILES:${PN}-relay += "\
    ${bindir}/gaeul2-relay-agent \
    ${libdir}/libgaeul-relay-2.0.so.* \
    ${datadir}/dbus-1/system.d/org.hwangsaeul.Gaeul2.Relay.conf \
    ${datadir}/glib-2.0/schemas/org.hwangsaeul.Gaeul2.Relay.gschema.xml \
"

PROVIDES = "${PACKAGES}"

SYSTEMD_SERVICE:${PN}-source = "gaeul2-source-agent.service"
SYSTEMD_AUTO_ENABLE:gaeul2-source-agent = "enable"

GAEUL2_AGENT_USER = "gaeul"
GAEUL2_AGENT_DIR = "${localstatedir}/lib/hwangsaeul/gaeul2"
GAEUL2_AGENT_CONFDIR = "${localstatedir}/lib/hwangsaeul/gaeul2/conf"

do_install:append() {

    # consider systemd only
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/debian/gaeul2-source-agent.service \
                    ${D}${systemd_unitdir}/system/

    install -d ${D}${sysconfdir}/default
    install -m 0644 ${S}/debian/gaeul2-source-agent.default \
                    ${D}${sysconfdir}/default/gaeul2-source-agent

    install -d ${D}${GAEUL2_AGENT_CONFDIR}
    install -m 0644 ${WORKDIR}/gaeul2.ini \
                    ${D}${GAEUL2_AGENT_CONFDIR}/

    chown ${GAEUL2_AGENT_USER} -R ${D}${GAEUL2_AGENT_DIR}

    install -d ${D}${sysconfdir}/gaeul2
    cd ${D}${sysconfdir}/gaeul2

    ln -s -r ${D}${GAEUL2_AGENT_CONFDIR}/gaeul2.ini 
}

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = " \
    --system \
    --home ${localstatedir}/lib/hwangsaeul/gaeul2 \
    --groups video,audio,plugdev \
    --user-group ${GAEUL2_AGENT_USER} \
"
