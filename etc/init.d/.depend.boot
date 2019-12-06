TARGETS = console-setup alsa-utils mountkernfs.sh ufw apparmor pppd-dns plymouth-log dns-clean x11-common hostname.sh udev keyboard-setup resolvconf mountdevsubfs.sh brltty procps hwclock.sh checkroot.sh checkfs.sh urandom checkroot-bootclean.sh kmod networking mountall.sh mountnfs.sh mountall-bootclean.sh mountnfs-bootclean.sh bootmisc.sh rc.local
INTERACTIVE = console-setup udev keyboard-setup checkroot.sh checkfs.sh
udev: mountkernfs.sh
keyboard-setup: mountkernfs.sh udev
resolvconf: dns-clean
mountdevsubfs.sh: mountkernfs.sh udev
brltty: mountkernfs.sh udev
procps: mountkernfs.sh udev
hwclock.sh: mountdevsubfs.sh
checkroot.sh: hwclock.sh keyboard-setup mountdevsubfs.sh hostname.sh
checkfs.sh: checkroot.sh
urandom: hwclock.sh
checkroot-bootclean.sh: checkroot.sh
kmod: checkroot.sh
networking: resolvconf mountkernfs.sh urandom dns-clean procps
mountall.sh: checkfs.sh checkroot-bootclean.sh
mountnfs.sh: networking
mountall-bootclean.sh: mountall.sh
mountnfs-bootclean.sh: mountnfs.sh
bootmisc.sh: mountnfs-bootclean.sh checkroot-bootclean.sh mountall-bootclean.sh udev
rc.local: udev keyboard-setup console-setup bluetooth rsyslog dbus kerneloops networking hwclock.sh resolvconf avahi-daemon alsa-utils urandom unattended-upgrades irqbalance mountkernfs.sh mountdevsubfs.sh checkroot.sh thermald speech-dispatcher lightdm uuidd cups-browsed cups whoopsie ufw saned rsync anacron cron apport acpid mountnfs-bootclean.sh mountnfs.sh bootmisc.sh apparmor checkroot-bootclean.sh checkfs.sh pppd-dns plymouth-log dns-clean x11-common brltty hostname.sh mountall-bootclean.sh mountall.sh kmod procps open-vm-tools
