package org.tretton63.demovaadin1363.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.scheduling.annotation.Scheduled;
import org.tretton63.demovaadin1363.models.ContactDetails;
import org.tretton63.demovaadin1363.models.Customer;
import org.tretton63.demovaadin1363.models.SparDetails;
import org.tretton63.demovaadin1363.repositories.CustomerRepository;

import java.time.Duration;

@Route
public class CustomerView extends VerticalLayout {

    private TextField agreementId = new TextField("Agreement Id");

    // Contact Details
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private TextField email = new TextField("Email");
    private TextField phone = new TextField("Phone");

    // Spar details

    private TextField id1 = new TextField("id1");
    private TextField id2 = new TextField("id2");


    private Button send = new Button("Send");

    private ContactDetails contactDetails = new ContactDetails();
    private SparDetails sparDetails = new SparDetails();
    private Customer customer = new Customer("", sparDetails, contactDetails);
    private CustomerRepository repository;

    public CustomerView(CustomerRepository repository) {
        this.repository = repository;
        setAlignItems(Alignment.CENTER);
        setSpacing(true);
        setPadding(true);

        Binder<Customer> customerBinder = new Binder<>(Customer.class);
        Binder<ContactDetails> contactDetailsBinder = new Binder<>(ContactDetails.class);
        Binder<SparDetails> sparDetailsBinder = new Binder<>(SparDetails.class);

        customerBinder.bindInstanceFields(this);
        contactDetailsBinder.bindInstanceFields(this);
        sparDetailsBinder.bindInstanceFields(this);
        contactDetailsBinder.setBean(contactDetails);
        sparDetailsBinder.setBean(sparDetails);
        customerBinder.setBean(customer);

        FormLayout form = new FormLayout();

        form.addFormItem(agreementId, "AgreementId");
        form.addFormItem(firstName, "First name");
        form.addFormItem(lastName, "Last name");
        form.addFormItem(email, "Email");
        form.addFormItem(phone, "Phone");
        form.addFormItem(id1, "SlutKundId");
        form.addFormItem(id2, "Behörighet");
        send.addClickListener((buttonClickEvent) -> {

            if (customerBinder.validate().isOk())
            {
                System.out.println("Saving repository");
                repository.save(customer);
            }


        });
        form.add(send);
        add(form);


    }


}
