# case-class-to-csv

This project provides a sample implementation of toCSV method for scala case class.
The method returns the csv string for the case class that can be used to write to a csv file.

    val student_1 = Student(
                    id = Some("1"),
                    name = Some("john"),
                    address = Some(Seq(
                                      Address(Some("Newyork"),Some("USA")),
                                      Address(Some("Berlin"),Some("Germany")),
                                      Address(Some("Tokyo"),Some("Japan"))
                                   )),
                    email = Some(Seq(
                                      Address(Some("abc@gmail.com"),Some(true)),
                                      Address(Some("cde@gmail.com"),Some(false))
                                   )),
                    phone = Some(Seq(
                                    "1111","9999","8888"
                                ))
                    )
So, student_1.csvHeaders() will return following output:

        StudentId,    Name,   Address.City,   Address.Province,   Email.value,   Email.IsPrimary,  Phones

So, now student_1.toCSV() will return following output:

       /*   List(      
        List(1,         john, Newyork,      USA,              abc@gmail.com,  true,            1111/9999/8888 ), 
        List( ,             , Berlin,       Germany,          cde@gmail.com,  false,                          ), 
        List( ,             , Tokyo,        Japan,                         ,      ,                           )
       ) 
         */


