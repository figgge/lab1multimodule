import org.example.service.Calculate;
import org.example.provider.Add;
import org.example.provider.Subtract;

module org.example.provider {
    requires org.example.service;
    opens org.example.provider;
    provides Calculate with Add, Subtract;
}
