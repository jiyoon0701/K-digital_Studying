package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
/*
 * @Component : 해당 클래스를 객체화
 * Service 기능 : Controller 와 Model사이의 중간 역할의 클래스 
 */
@Service  //@Component + Service 기능
public class ShopService {
	@Autowired  //ItemDao 객체를 주입. 
	private ItemDao itemDao;

	public List<Item> itemList() {
		return itemDao.list();
	}

	public Item getItem(Integer id) {
		// TODO Auto-generated method stub
		return itemDao.getItem(id);
	}
}
