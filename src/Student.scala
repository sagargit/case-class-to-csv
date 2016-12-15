case class Address(
                    city: Option[String] = None,
                    province: Option[String] = None
                    )
case class Email(
                  value: Option[String] = None,
                  isPrimary: Option[String] = None
                  )

case class Student(
                    id: Option[String] = None,
                    name: Option[String] = None,
                    address: Option[Seq[Address]] = None,
                    email: Option[Seq[Email]] = None,
                    phone: Option[Seq[String]] = None
                    )
{
  /**
   *
   * @return a line, this line represents the first row of csv
   */
  def csvHeaders:String = {
    List("StudentId","Name","Address.City","Address.Province","Email.value","Email.IsPrimary","Phones").mkString(",")
  }

  /**
   *
   * @return list of lines, Each line represents a row of csv
   */
  def toCSV:List[String] ={

    val maximumLength = address.getOrElse(Seq.empty[Address]).length max email.getOrElse(Seq.empty[Email]).length

    val idList = List.tabulate(maximumLength)(k => " ").updated(0,id.getOrElse(""))

    val nameList = List.tabulate(maximumLength)(k => " ").updated(0,name.getOrElse(""))

    val addressCityList = if(address.isDefined){
      address.get.map{
        k => k.city.getOrElse(" ")
      }.toList.padTo(maximumLength," ")
    } else{
      List.tabulate(maximumLength)(k => " ")
    }

    val addressProvinceList = if(address.isDefined){
      address.get.map{
        k => k.province.getOrElse(" ")
      }.toList.padTo(maximumLength," ")
    } else{
      List.tabulate(maximumLength)(k => " ")
    }

    val emailValueList = if(email.isDefined){
      email.get.map{
        k => k.value.getOrElse(" ")
      }.toList.padTo(maximumLength," ")
    } else{
      List.tabulate(maximumLength)(k => " ")
    }

    val emailIsPrimaryList = if(email.isDefined){
      email.get.map{
        k => k.isPrimary.getOrElse(" ")
      }.toList.padTo(maximumLength," ")
    } else{
      List.tabulate(maximumLength)(k => " ")
    }

    val phoneList = if(phone.isDefined){
      List.tabulate(maximumLength)(k => " ").updated(0,phone.get.padTo(maximumLength," ").mkString("/"))
    } else{
      List.tabulate(maximumLength)(k => " ")
    }

    val transposedList:List[List[String]] = List(idList,nameList,addressCityList,addressProvinceList,emailValueList,emailIsPrimaryList,phoneList).transpose

    transposedList.map{
      k => k.mkString(",")
    }
  }


}