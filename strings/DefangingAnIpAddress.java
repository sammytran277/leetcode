// https://leetcode.com/problems/defanging-an-ip-address/

public class DefangingAnIpAddress {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}