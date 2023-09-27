package com.amc.java.practice.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @author Amitava Chakraborty
 * Aug 31, 2000 
 * Part of the object serialization example demonstrating custom read/write.
 * Lets assume this class represents something like a password file entry and
 * contains the encrypted password at runtime. The company has deemed that it is
 * acceptable to keep this information in memory, but never on disk except in
 * the shadow password file, which is protected. This class will use a custom
 * read/write External methods to perform serializtion.
 */

public class UserInfo extends Object implements Externalizable {
	private String login;
	private int UID;
	private String passwd;
	private String homeDir;

	// on and on, but we'll skip it

	public UserInfo() {
		// must be here so the VM can contruct the object to be desreialized
	}

	public UserInfo(String login, int UID, String passwd, String homeDir) {
		this.login = login;
		this.passwd = passwd;
		this.UID = UID;
		this.homeDir = homeDir;
	}

	/**
	 * Serialize all fields except password field. Generate and append MD5.
	 */
	public void writeExternal(ObjectOutput out) throws IOException {
		byte[] digest = null;

		// compute a MD5 digest
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5", "SUN");
			String workStr = new String(login + UID + homeDir);

			digest = md5.digest(workStr.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} // catch

		// write fields
		out.writeObject(login);
		out.writeInt(UID);
		out.writeObject(homeDir);

		// write the digest length and digest itself
		// need the length to read it in later
		out.writeInt(digest.length);
		System.out.println("Digest is " + digest.length + " bytes.");
		out.write(digest);
		out.flush();
	}

	/**
	 * Opposite of writeExternal, check MD5.
	 */
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		byte[] digest = null;
		int md5Len;

		// read fields
		this.login = (String) in.readObject();
		this.UID = in.readInt();
		this.homeDir = (String) in.readObject();

		// read the digest, allocate byte array
		md5Len = in.readInt();
		digest = new byte[md5Len];

		// read the MD5 data
		for (int count = 0; count < md5Len; count++) {
			digest[count] = in.readByte();
		} // for

		// check the MD5 data
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5", "SUN");
			String workStr = new String(login + UID + homeDir);

			// compute a digest
			if (!(md5.isEqual(md5.digest(workStr.getBytes()), digest))) {
				System.err.println("Problem with UserInfo, aborting.");
				System.exit(1);
			} else {
				System.out.println("User De-serialized, MD5 okay.");
			} // else
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} // catch

	}

}
