package PasswordEncryption;

import java.security.MessageDigest;

public class SHA256 {
    public static final String algorithm = "SHA-256";
    private String userPassword;
    private String hashPassword;

    public SHA256(String pass)
    {
        userPassword = pass;
    }

    public String getHash()
    {
        sha256(userPassword);
        return hashPassword;
    }

    public void sha256(String base) {

        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for(int i=0;i<hash.length;i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length()==1)
                    hexString.append('0');
                hexString.append(hex);
            }

            hashPassword = hexString.toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }

    }
}
