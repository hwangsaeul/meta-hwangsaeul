DEPENDS:append = " srt"
PACKAGECONFIG:append = " srt"
PACKAGECONFIG[srt] = "-Dsrt=enabled,-Dsrt=disabled,srt"
