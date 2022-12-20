package logic;

import java.io.File;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dao.BoardDao;
import dao.ItemDao;
import dao.SaleDao;
import dao.SaleItemDao;
import dao.UserDao;
/*
 * @Component : 해당 클래스를 객체화
 * Service 기능 : Controller 와 Model사이의 중간 역할의 클래스 
 */
@Service  //@Component + Service 기능
public class ShopService {
	@Autowired  //ItemDao 객체를 주입. 
	private ItemDao itemDao;
	@Autowired   
	private UserDao userDao;
	@Autowired
	private SaleDao saleDao;
	@Autowired
	private SaleItemDao saleItemDao;
	@Autowired
	private BoardDao boardDao;

	public List<Item> itemList() {
		return itemDao.list();
	}

	public Item getItem(Integer id) {
		// TODO Auto-generated method stub
		return itemDao.getItem(id);
	}

	//db에 내용 저장. 파일 업로드
	//item : 저장정보. 입력된 파라미터값 + 업로드된 파일의 내용
	public void itemCreate(Item item, HttpServletRequest request) {
		//item.getPicture() : 업로드된 파일의 내용
		if(item.getPicture() != null &&   //업로드된 파일이 존재. 
				!item.getPicture().isEmpty()) {
			String uploadPath = 
			request.getServletContext().getRealPath("/") + "img/";
			uploadFileCreate(item.getPicture(),uploadPath);//업로드구현
			item.setPictureUrl  //파일의 이름
			(item.getPicture().getOriginalFilename());
		}
		//maxid : item 테이블 중 최대 id값
		int maxid = itemDao.maxId();
		item.setId(maxid+1);
		itemDao.insert(item);
	}
	public void itemUpdate(Item item, HttpServletRequest request) {
		if(item.getPicture() != null && 
				!item.getPicture().isEmpty()) { //파일 업로드 됨
			String uploadPath = 
			request.getServletContext().getRealPath("/")+"img/";
			//파일업로드 : 업로드된 내용을 서버에 파일 저장
			uploadFileCreate(item.getPicture(), uploadPath);
			item.setPictureUrl  //파일이름을 db에 등록하기 위해 설정
			(item.getPicture().getOriginalFilename());
		}
		itemDao.update(item);
	}

	private void uploadFileCreate
	                 (MultipartFile file, String uploadPath) {
		//uploadPath : 파일이 업로드 되는 폴더
		String orgFile = file.getOriginalFilename(); //파일이름
		File fpath = new File(uploadPath); 
		if(!fpath.exists()) fpath.mkdirs(); //업로드 폴더가 없으면 생성
		try {
			//파일의 내용 => uploadPath + orgFile 로 파일 저장
			file.transferTo
			       (new File(uploadPath + orgFile)); //파일업로드
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void itemDelete(Integer id) {
		itemDao.delete(id);
	}

	public void userInsert(User user) {
		userDao.insert(user);
	}

	public User getUser(String userid) {
		return userDao.selectOne(userid);
	}

	public void userUpdate(User user) {
		userDao.update(user);
	}

	public void userDelete(String userid) {
		userDao.delete(userid);
	}

	public void userChgpass(String userid, String pass) {
		userDao.chgpass(userid,pass);
	}

	public String getSearch(User user, String url) {
		return userDao.search(user,url);
	}

	public List<User> userlist() {
		return userDao.list();
	}

	/*
	 * 로그인정보, 장바구니 정보에서 sale,saleitem 테이블에 데이터 저장
	 * 결과를 Sale 객체로 저장
	 * 1. sale 테이블의 saleid의 최대값 조회
	 * 2. sale 테이블에 saleid의 최대값+1, userid, sysdate 등록
	 * 3. Cart 데이터에서 saleitem 데이터를 저장 
	 * 4. Sale 객체에 모든 데이터 저장
	 */
	public Sale checkend(User loginUser, Cart cart) {
		//1. sale 테이블의 saleid의 최대값 조회
		int maxid = saleDao.getMaxSaleId();
		//2. sale 테이블에 saleid의 최대값+1, userid, sysdate 등록
		Sale sale = new Sale();
		sale.setSaleid(maxid+1);
		sale.setUserid(loginUser.getUserid());
		sale.setUser(loginUser);
		saleDao.insert(sale); //sale 테이블에 데이터 저장
		//3. Cart 데이터에서 saleitem 데이터를 저장
		int seq = 0;
		for(ItemSet is : cart.getItemSetList()) {
			SaleItem saleItem = new SaleItem
					(sale.getSaleid(),++seq,is);
			sale.getItemList().add(saleItem);
			saleItemDao.insert(saleItem); //saleitem 테이블에 저장
		}
		return sale;
	}

	public List<Sale> salelist(String id) {
		//sale테이블의 내용 저장
		List<Sale> list = saleDao.list(id);//id 사용자가 주문 정복목록 
		for(Sale sa : list) {
			//주문별 주문 상품 조회
			List<SaleItem> saleitemlist = 
					           saleItemDao.list(sa.getSaleid());
			//SaleItem 객체에 Item 객체 저장
			for(SaleItem si : saleitemlist) {
				Item item = itemDao.getItem(si.getItemid());
				si.setItem(item); //Item 객체를 SaleItem객체에 추가
			}
			//Sale 객체에 SaleItem 목록 추가
			sa.setItemList(saleitemlist);
		}
		return list;
	}

	 public int boardcount(String boardid) {
		return boardDao.count(boardid);
	}

	public List<Board> boardlist
	        (Integer pageNum, int limit, String boardid) {
		return boardDao.list(pageNum,limit,boardid);
	}

	public void boardwrite(Board board, HttpServletRequest request) {
      //첨부 파일이 존재 : 파일 업로드
	  if(board.getFile1() != null && !board.getFile1().isEmpty()){
        String path=request.getServletContext().getRealPath("/") +
        		  "board/file/";
		uploadFileCreate(board.getFile1(),path);
		board.setFileurl(board.getFile1().getOriginalFilename());
	  }
	  //1. num 컬럼의 최대값
	  //2. board 테이블에 저장
	  boardDao.insert(board);
	}
	public Board getBoard(Integer num) {
		return boardDao.selectOne(num);
	}
	public void readcntadd(Integer num) {
		boardDao.readcntadd(num);		
	}
	//파일업로드, db 수정
	public void boardUpdate
	        (Board board, HttpServletRequest request) {
		//수정시 파일업로드가 발생됨. 첨부파일 수정됨 
		if(board.getFile1()!=null && !board.getFile1().isEmpty()) {
		  String path = request.getServletContext().getRealPath("/")
					+ "board/file/";
		  uploadFileCreate(board.getFile1(),path);
		  board.setFileurl(board.getFile1().getOriginalFilename());
		}
		boardDao.update(board);
	}

	public void boardReply( Board board) {
		 //순서지정. 원글에 grpstep보다 큰 grpstep을 가진 레코드의
		//         grpstep의 값을 +1 수정 
		boardDao.grpStepAdd(board);
		boardDao.reply(board);
	}

	public void boardDelete(Integer num) {
		boardDao.delete(num);
	}

	public Map<String, Integer> graph1(String id) {
		List<Map<String,Object>> list = boardDao.graph1(id);
	     /* [{WRITER=홍길동,CNT=3},
          * {WRITER=김삿갓,CNT=2},
	      * {WRITER=이몽룡,CNT=1}]
		*/
		System.out.println(list);
		/*
		 * {홍길동=3,김삿갓=2,이몽룡=1} 형태로 변경하기
		 */
		Map<String,Integer> map = new HashMap<>();
		for(Map<String,Object> m : list) {
			//WRITER : 컬럼명. 오라클은 대문자로 출력됨
			//m : {WRITER=이몽룡,CNT=1}
		    String writer =(String)m.get("WRITER"); //이몽룡
		    long bcnt = ((BigDecimal) m.get("CNT")).longValue(); 
		    Integer cnt = (int)bcnt; //등록건수값
		    map.put(writer,cnt); //{"홍길동"=3,"김삿갓"=2,"이몽룡"=1}
		}
		return map;
	}

	public Map<String, Integer> graph2(String id) {
		List<Map<String,Object>> list = boardDao.graph2(id);
		//list : [{DAY="22-10-11",CNT=5},{DAY="22-10-10",CNT=10}...]
		//날짜의 역순으로 저장
		Map<String,Integer> map = 
				         new TreeMap<>(Comparator.reverseOrder());
		for(Map<String,Object> m : list) { 
			String day =(String)m.get("DAY");
			long bcnt = ((BigDecimal) m.get("CNT")).longValue(); 
			Integer cnt = (int)bcnt; 
			map.put(day,cnt);
		}
		//map : {"22-10-11"=5,"22-10-10"=10,....}
		System.out.println(map);
		return map;
	}
}
