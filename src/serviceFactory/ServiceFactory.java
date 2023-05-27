package serviceFactory;

import service.ServiceImpl;

public class ServiceFactory {
	static ServiceImpl serviceImp=null;
	
	public static ServiceImpl getService() {
		if(serviceImp==null)
			return new ServiceImpl();
		else 
			return serviceImp;
	}

}
