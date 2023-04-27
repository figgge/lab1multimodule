import org.example.service.Calculate;
import org.example.provider.Add;
import org.example.provider.Subtract;
import org.example.provider.Multiply;
import org.example.provider.Divide;

module org.example.provider {
    requires org.example.service;
    opens org.example.provider;
    provides Calculate with Add, Subtract, Multiply, Divide;
}
