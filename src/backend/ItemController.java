package backend;



@Controller
@RequestMapping(value = "/item")
public class ItemController {

	private final ItemService itemService;
	
	@Autowired
	public ItemController(final ItemService itemService) {
		this.itemService = itemService;
	}
	
	@RequestMapping(value = "/", method = {RequestMethod.GET})
	@ResponseBody
	public List<Item> getItems() {
		return itemService.getItems();
	}
	

}
