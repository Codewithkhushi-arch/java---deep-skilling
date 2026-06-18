interface CustomerRepository { String findCustomerById(String id); }
class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) { return "Customer " + id; }
}
class CustomerService {
    private CustomerRepository repository;
    public CustomerService(CustomerRepository repository) { this.repository = repository; }
    public void printCustomer(String id) { System.out.println(repository.findCustomerById(id)); }
}
public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.printCustomer("C123");
    }
}

/*
Output:
Customer C123
*/
