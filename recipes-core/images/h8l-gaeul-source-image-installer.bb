require image.inc

WKS_FILE = "image-installer.wks.in"
IMAGE_FSTYPES:append = " ext4"
IMAGE_TYPEDEP_wic = "ext4"
INITRD_IMAGE_LIVE="core-image-minimal-initramfs"
do_image_wic[depends] += "${INITRD_IMAGE_LIVE}:do_image_complete"
do_rootfs[depends] += "virtual/kernel:do_deploy"
IMAGE_BOOT_FILES:append = "\
    ${KERNEL_IMAGETYPE} \
    microcode.cpio \
    ${IMGDEPLOYDIR}/${IMAGE_BASENAME}-${MACHINE}.ext4;rootfs.img \
    ${@bb.utils.contains('EFI_PROVIDER', 'grub-efi', 'grub-efi-bootx64.efi;EFI/BOOT/bootx64.efi', '', d)} \
    ${@bb.utils.contains('EFI_PROVIDER', 'grub-efi', '${IMAGE_ROOTFS}/boot/EFI/BOOT/grub.cfg;EFI/BOOT/grub.cfg', '', d)} \
    ${@bb.utils.contains('EFI_PROVIDER', 'systemd-boot', 'systemd-bootx64.efi;EFI/BOOT/bootx64.efi', '', d)} \
    ${@bb.utils.contains('EFI_PROVIDER', 'systemd-boot', '${IMAGE_ROOTFS}/boot/loader/loader.conf;loader/loader.conf ', '', d)} \
    ${@bb.utils.contains('EFI_PROVIDER', 'systemd-boot', '${IMAGE_ROOTFS}/boot/loader/entries/boot.conf;loader/entries/boot.conf', '', d)} "
