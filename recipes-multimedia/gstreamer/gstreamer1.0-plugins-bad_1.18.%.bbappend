DEPENDS_append = " srt"
PACKAGECONFIG_append = " srt"
PACKAGECONFIG[srt] = "-Dsrt=enabled,-Dsrt=disabled,srt"
