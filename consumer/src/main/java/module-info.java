import org.example.service.Calculate;

module org.example.consumer {
    requires org.example.service;
    uses Calculate;
}
