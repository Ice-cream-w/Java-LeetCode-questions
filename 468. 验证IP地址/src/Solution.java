import java.util.Locale;

/*
给定一个字符串queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；
如果不是上述类型的 IP 地址，返回 "Neither" 。

有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中0 <= xi<= 255且xi不能包含 前导零。
例如:“192.168.1.1”、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址;
“192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。

一个有效的IPv6地址是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:1 <= xi.length <= 4
xi是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
在xi中允许前导零。
例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，
而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。

 */
class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(":") && queryIP.length() < 40)
            return ipv6(queryIP);
        else if(queryIP.contains(".") && queryIP.length() < 16)
            return ipv4(queryIP);
        else return "Neither";
    }

    public String ipv4(String s1){
        if (s1.isEmpty() || 0 == s1.indexOf(".") || s1.length()-1 == s1.lastIndexOf(".") || !s1.toLowerCase().equals(s1.toUpperCase())){
            return "Neither";
        }
        String[] s2 = s1.split("\\.");

        if (s2.length == 4){
            for(int i = 0 ; i <= 3 ; i ++){
                //空串排除,前导0排除
                if ((1 < s2[i].length() && 0 != s2[i].indexOf("0")) || s2[i].length() == 1) {
                    //转换数字比较
                    Integer integer = Integer.parseInt(s2[i]);
                    if (0 > integer || 255 < integer)
                        return "Neither";
                }
                else
                    return "Neither";
            }
            return "IPv4";
        }
        return "Neither";
    }

    public String ipv6(String s1){
        if (s1.isEmpty() || 0 == s1.indexOf(":") || s1.length()-1 == s1.lastIndexOf(":")){
            return "Neither";
        }
        String[] s2= s1.split(":");

        if (s2.length == 8){
            for(int i = 0 ; i <= 7 ; i ++){
                //不是四个字符
                if (s2[i].length() > 4 || s2[i].length() < 1)
                    return "Neither";

                //比较每个字符是否在0-9和a-z中
                int j = 0;
                while(j < s2[i].length()){
                    char c = s2[i].charAt(j);
                    if ((47 < c && c < 58) || (64 < c && c < 71) || (96 < c && 103 >c))
                        j ++;
                    else return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
}