package com.example.administrator.util.string;

public class TokenUtils {
    /**
     * Is the AccessToken in URL correct?
     * @param url
     * @param name
     * @param accessToken
     * @return
     */
    public static boolean isAccessToken(String url, String name, String accessToken){
        if (StringUtils.isNotBlank(url) && StringUtils.isNotBlank(accessToken)) {
            int index1 = url.indexOf(name + "=");
            if (index1 != -1) {
                int index2 = url.indexOf("&", index1);
                if(index2 == -1) index2 = url.length();
                if((name + "=" + accessToken).equals(url.substring(index1, index2)))
                    return true;
                else return false;
            }
        }
        return false;
    }

    /**
     * Replace the AccessToken in URL.
     * @param url
     * @param name
     * @param accessToken
     * @return
     */
    public static String replaceAccessToken(String url, String name, String accessToken) {
        if (StringUtils.isNotBlank(url) && StringUtils.isNotBlank(accessToken)) {
            int index = url.indexOf(name + "=");
            if (index != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(url.substring(0, index)).append(name + "=").append(accessToken);
                int idx = url.indexOf("&", index);
                if (idx != -1) {
                    sb.append(url.substring(idx));
                }
                url = sb.toString();
            }
        }
        return url;
    }
}