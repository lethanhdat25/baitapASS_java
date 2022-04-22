import com.example.hello_springboot.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/productlist")
public class Products {
    private static List<Product> listProduct;
    static {
        listProduct = new ArrayList<>();
        listProduct.add(new Product(1,"asda","asfas",3232,1));
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        listProduct.add(product);
        return product;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getList(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue ="10") int limit){
        System.out.println("Page:" + page);
        System.out.println("Limit:" + limit);
        return listProduct;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Product getDetail(@PathVariable int id){
        Product found = null;
        for(Product pr : listProduct){
            if( pr.getId() == id){
                found = pr;
                break;
            }
        }
        return found;
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Product update(@PathVariable int id, @RequestBody Product updateProduct) {
        Product found = null;
        for (Product pr : listProduct) {
            if (pr.getId() == id) {
                found = pr;
                break;
            }
        }
        if (found != null) {
            found.setId(updateProduct.getId());
            found.setName(updateProduct.getName());
            found.setDescription(updateProduct.getDescription());
            found.setPrice(updateProduct.getPrice());
            found.setStatus(updateProduct.getStatus());
        }
        return found;
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public String delete(@PathVariable int id) {
        Product found = null;
        for (Product pr : listProduct) {
            if (pr.getId() == id) {
                found = pr;
                break;
            }
        }
        if (found != null) {
            listProduct.remove(found);
        }
        return "ok";
    }
}
