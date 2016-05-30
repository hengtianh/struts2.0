package com.maker.service;

import com.maker.entity.User;

public interface UserService {
    /**
     * �û�ע��
     * @param user
     * @return ע��ɹ�����true��ʧ�ܷ���false
     */
	public boolean register(User user);
	
	/**
	 * �û���¼
	 * @param stuID
	 * @param password
	 * @param isBoss �Ƿ�Ϊ����
	 * @return ��¼�ɹ�����true,ʧ�ܷ���false
	 */
	public User login(String stuID,String password,boolean isBoss);
	
	/**
	 * �������
	 * @param stuID
	 * @return ��ͨ�û�����Ϊ�����û�
	 */
	public boolean uplevel(String stuID);
}
