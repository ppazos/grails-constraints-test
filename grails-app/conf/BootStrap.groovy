class BootStrap {

    def grailsApplication

    def init = { servletContext ->
    
        grailsApplication.domainClasses.each {
        
           //println it.toString() // org.codehaus.groovy.grails.commons.DefaultGrailsDomainClass
           //println it.class // org.codehaus.groovy.grails.commons.DefaultGrailsDomainClass
           println it.clazz // class representation.Cluster
           
           // Map property -> ConstrainedProperty que tiene un conjunto de constraints
           it.clazz.constraints.each { k, v ->
           
              println k // nombre de la ropiedad restringida
              println v.class // class org.codehaus.groovy.grails.validation.ConstrainedProperty
           }
           // Si tiene hasMany:
           // [items:org.codehaus.groovy.grails.validation.ConstrainedProperty@1228caa[
           //   class representation.Cluster,items,interface java.util.Set, {
           //     nullable=org.codehaus.groovy.grails.validation.NullableConstraint@140f8c3[true] }
           // ]]
           //
           // Constraint sobre string:
           // [value:org.codehaus.groovy.grails.validation.ConstrainedProperty@8bfa09[
           //   class representation.Element,value,class java.lang.String, {
           //     maxSize=org.codehaus.groovy.grails.validation.MaxSizeConstraint@1cc903c[1024], 
           //     nullable=org.codehaus.groovy.grails.validation.NullableConstraint@1116cae[false] }
           // ]]
           
           
           println ""
        }
    
        // Agrego una constraint por nombre
        // Se que existe un ConstrainedProperty para items por defecto
        // API: http://grails.org/doc/latest/api/org/codehaus/groovy/grails/validation/ConstrainedProperty.html
        representation.Cluster.constraints.items.applyConstraint('size', 10..30)
        println representation.Cluster.constraints.items
        /*
        org.codehaus.groovy.grails.validation.ConstrainedProperty@17a8b43[
          class representation.Cluster,items,interface java.util.Set,{
            nullable=org.codehaus.groovy.grails.validation.NullableConstraint@4ce091[true], 
            size=org.codehaus.groovy.grails.validation.SizeConstraint@12b76b9[10..30]
          }
        ]
        */
    }
    def destroy = {
    }
}
