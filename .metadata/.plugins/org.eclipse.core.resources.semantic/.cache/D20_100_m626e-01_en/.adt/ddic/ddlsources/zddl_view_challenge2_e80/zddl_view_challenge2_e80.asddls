@AbapCatalog.sqlViewName: 'ZCDS_VIEW_C2_E80'
@AbapCatalog.compiler.compareFilter: true
@AbapCatalog.preserveKey: true
@AccessControl.authorizationCheck: #CHECK
@EndUserText.label: 'C2'
define view ZDDL_VIEW_CHALLENGE2_E80
    with parameters
        pa_carrier : s_carr_id
    as select from      ztt_employee_e80 as employees
        left outer join ztt_depment_e80  as depments
        on employees.carrier    = depments.carrier and
           employees.department = depments.department
    {
        key employees.carrier as id_carrier,
        key employees.id_employee,
            employees.lastname,
            employees.firstname,
            employees.department,
            depments.tel,
            depments.fax,
            employees.area,
            @Semantics.amount.currencyCode: 'currency'
            employees.salary,
            @Semantics.currencyCode: true
            employees.currency
    }
    where
        employees.carrier = $parameters.pa_carrier