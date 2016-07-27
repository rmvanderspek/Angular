package backend;

public class ItemService {
	
	private final ItemRepository itemRepository;
	
	@Autowired
	public ItemService(final ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public List<Item> getItems(){
		return itemRepository.findAll();
	}

}
