package our.company.name.utils.device.detection;

import com.vaadin.server.WebBrowser;

public class CompleteDeviceDetails {

	@SuppressWarnings("unused")
	private WebBrowser webBrowser;

	private Boolean isConnectionSecure;
	private String ipAddress;
	private OSType osType;
	private DeviceType deviceType;
	private int deviceScreenHeight;
	private int deviceScreenWidth;
	private BrowserType browserType;
	private int browserMajorVersionNumber;
	private int browserMinorVersionNumber;


	public CompleteDeviceDetails(WebBrowser webBrowser) {

		// Set the browser info object
		this.webBrowser = webBrowser;

		// Detect Operating System
		if (webBrowser.isLinux())
			osType = OSType.LINUX_OS;
		else if (webBrowser.isWindows())
			osType = OSType.WINDOWS_OS;
		else if (webBrowser.isMacOSX())
			osType = OSType.MAC_OS;
		else
			osType = OSType.UNKNOWN_OS;

		// Detect Device Type
		if (webBrowser.isTouchDevice()) {
			if (webBrowser.isAndroid())
				deviceType = DeviceType.ANDROID_MOBILE;
			else if (webBrowser.isIOS())
				deviceType = DeviceType.IOS_MOBILE;

		} else {
			deviceType = DeviceType.PC;
		}

		// Detect Browser Type
		if (webBrowser.isChrome())
			browserType = BrowserType.CHROME_BROWSER;
		else if (webBrowser.isFirefox())
			browserType = BrowserType.FIREFOX_BROWSER;
		else if (webBrowser.isIE())
			browserType = BrowserType.IE_BROWSER;
		else if (webBrowser.isSafari())
			browserType = BrowserType.SAFARI_BROWSER;
		else if (webBrowser.isOpera())
			browserType = BrowserType.OPERA_BROWSER;
		else
			browserType = BrowserType.UNKNOWN_BROWSER;

		// Get Browser Version Details
		browserMajorVersionNumber = webBrowser.getBrowserMajorVersion();
		browserMinorVersionNumber = webBrowser.getBrowserMinorVersion();

		// Get Connection Details
		isConnectionSecure = webBrowser.isSecureConnection();

		// Get Screen size
		deviceScreenHeight = webBrowser.getScreenWidth();
		deviceScreenWidth = webBrowser.getScreenHeight();

		// Get IP address
		ipAddress = webBrowser.getAddress();

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompleteDeviceDetails [isConnectionSecure=");
		builder.append(isConnectionSecure);
		builder.append(", ipAddress=");
		builder.append(ipAddress);
		builder.append(", osType=");
		builder.append(osType);
		builder.append(", deviceType=");
		builder.append(deviceType);
		builder.append(", deviceScreenHeight=");
		builder.append(deviceScreenHeight);
		builder.append(", deviceScreenWidth=");
		builder.append(deviceScreenWidth);
		builder.append(", browserType=");
		builder.append(browserType);
		builder.append(", browserMajorVersionNumber=");
		builder.append(browserMajorVersionNumber);
		builder.append(", browserMinorVersionNumber=");
		builder.append(browserMinorVersionNumber);
		builder.append("]");
		return builder.toString();
	}

}
