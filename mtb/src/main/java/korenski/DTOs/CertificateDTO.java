package korenski.DTOs;

import java.util.Date;

public class CertificateDTO {
	public String alias;
	public String keyAlias;
	public String keyPassword;
	public String keyPasswordConf;
	public boolean selfSigned;
	public String issuerAlias;
	public String cn;
	public String surname;
	public String givenName;
	public String organization;
	public String organizationUnit;
	public String country;
	public String email;
	public String uid;
	public boolean ca;
	public Date validFrom;
	public Date validTo; 
	
	public CertificateDTO() {
		// TODO Auto-generated constructor stub
	}
}
