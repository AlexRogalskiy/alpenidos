package com.sensiblemetrics.api.alpenidos.core.commander;

import com.sensiblemetrics.api.alpenidos.core.commander.employee_service.EmployeeDatabase;
import com.sensiblemetrics.api.alpenidos.core.commander.employee_service.EmployeeHandle;
import com.sensiblemetrics.api.alpenidos.core.commander.exception.DatabaseUnavailableException;
import com.sensiblemetrics.api.alpenidos.core.commander.impl.Commander;
import com.sensiblemetrics.api.alpenidos.core.commander.messaging_service.MessagingDatabase;
import com.sensiblemetrics.api.alpenidos.core.commander.messaging_service.MessagingService;
import com.sensiblemetrics.api.alpenidos.core.commander.model.Order;
import com.sensiblemetrics.api.alpenidos.core.commander.model.User;
import com.sensiblemetrics.api.alpenidos.core.commander.payment_service.PaymentDatabase;
import com.sensiblemetrics.api.alpenidos.core.commander.payment_service.PaymentService;
import com.sensiblemetrics.api.alpenidos.core.commander.queue.QueueDatabase;
import com.sensiblemetrics.api.alpenidos.core.commander.shipping_service.ShippingDatabase;
import com.sensiblemetrics.api.alpenidos.core.commander.shipping_service.ShippingService;

/**
 * AppMessagingFailCases class looks at possible cases when Messaging service is
 * available/unavailable.
 */
public class AppMessagingFailCases {
    private final int numOfRetries = 3;
    private final long retryDuration = 30000;
    private final long queueTime = 240000; //4 mins
    private final long queueTaskTime = 60000; //1 min
    private final long paymentTime = 120000; //2 mins
    private final long messageTime = 150000; //2.5 mins
    private final long employeeTime = 240000; //4 mins

    void messagingDatabaseUnavailableCasePaymentSuccess() throws Exception {
        //rest is successful
        final PaymentService ps = new PaymentService(new PaymentDatabase());
        final ShippingService ss = new ShippingService(new ShippingDatabase());
        final MessagingService ms = new MessagingService(
            new MessagingDatabase(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final EmployeeHandle eh = new EmployeeHandle(new EmployeeDatabase());
        final QueueDatabase qdb = new QueueDatabase();
        final Commander c = new Commander(eh, ps, ss, ms, qdb, numOfRetries, retryDuration, queueTime, queueTaskTime, paymentTime, messageTime, employeeTime);
        final User user = new User("Jim", "ABCD");
        final Order order = new Order(user, "book", 10f);
        c.placeOrder(order);
    }

    void messagingDatabaseUnavailableCasePaymentError() throws Exception {
        //rest is successful
        final PaymentService ps = new PaymentService(new PaymentDatabase(), new DatabaseUnavailableException(),
            new DatabaseUnavailableException(), new DatabaseUnavailableException(), new DatabaseUnavailableException(),
            new DatabaseUnavailableException(), new DatabaseUnavailableException());
        final ShippingService ss = new ShippingService(new ShippingDatabase());
        final MessagingService ms = new MessagingService(
            new MessagingDatabase(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final EmployeeHandle eh = new EmployeeHandle(new EmployeeDatabase());
        final QueueDatabase qdb = new QueueDatabase();
        final Commander c = new Commander(eh, ps, ss, ms, qdb, numOfRetries, retryDuration, queueTime, queueTaskTime, paymentTime, messageTime, employeeTime);
        final User user = new User("Jim", "ABCD");
        final Order order = new Order(user, "book", 10f);
        c.placeOrder(order);
    }

    void messagingDatabaseUnavailableCasePaymentFailure() throws Exception {
        //rest is successful
        final PaymentService ps = new PaymentService(
            new PaymentDatabase(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final ShippingService ss = new ShippingService(new ShippingDatabase());
        final MessagingService ms = new MessagingService(
            new MessagingDatabase(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final EmployeeHandle eh = new EmployeeHandle(new EmployeeDatabase());
        final QueueDatabase qdb = new QueueDatabase(
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final Commander c = new Commander(eh, ps, ss, ms, qdb, numOfRetries, retryDuration, queueTime, queueTaskTime, paymentTime, messageTime, employeeTime);
        final User user = new User("Jim", "ABCD");
        final Order order = new Order(user, "book", 10f);
        c.placeOrder(order);
    }

    void messagingSuccessCase() throws Exception {
        //done here
        final PaymentService ps = new PaymentService(
            new PaymentDatabase(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException());
        final ShippingService ss = new ShippingService(new ShippingDatabase());
        final MessagingService ms = new MessagingService(
            new MessagingDatabase(),
            new DatabaseUnavailableException(),
            new DatabaseUnavailableException()
        );
        final EmployeeHandle eh = new EmployeeHandle(new EmployeeDatabase());
        final QueueDatabase qdb = new QueueDatabase();
        final Commander c = new Commander(eh, ps, ss, ms, qdb, numOfRetries, retryDuration, queueTime, queueTaskTime, paymentTime, messageTime, employeeTime);
        final User user = new User("Jim", "ABCD");
        final Order order = new Order(user, "book", 10f);
        c.placeOrder(order);
    }

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) throws Exception {
        AppMessagingFailCases amfc = new AppMessagingFailCases();
        //amfc.messagingDatabaseUnavailableCasePaymentSuccess();
        //amfc.messagingDatabaseUnavailableCasePaymentError();
        //amfc.messagingDatabaseUnavailableCasePaymentFailure();
        amfc.messagingSuccessCase();
    }
}