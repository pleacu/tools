/**
 */
package org.switchyard.tools.models.switchyard1_0.camel.jpa.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.soa.sca.sca1_1.model.sca.Binding;
import org.eclipse.soa.sca.sca1_1.model.sca.CommonExtensionBase;

import org.switchyard.tools.models.switchyard1_0.camel.jpa.*;

import org.switchyard.tools.models.switchyard1_0.switchyard.SwitchYardBindingType;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.switchyard.tools.models.switchyard1_0.camel.jpa.JpaPackage
 * @generated
 */
public class JpaSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static JpaPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JpaSwitch() {
        if (modelPackage == null) {
            modelPackage = JpaPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case JpaPackage.ADDITIONAL_URI_PARAMETERS_TYPE: {
                AdditionalUriParametersType additionalUriParametersType = (AdditionalUriParametersType)theEObject;
                T result = caseAdditionalUriParametersType(additionalUriParametersType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case JpaPackage.BASE_CAMEL_BINDING: {
                BaseCamelBinding baseCamelBinding = (BaseCamelBinding)theEObject;
                T result = caseBaseCamelBinding(baseCamelBinding);
                if (result == null) result = caseSwitchYardBindingType(baseCamelBinding);
                if (result == null) result = caseBinding(baseCamelBinding);
                if (result == null) result = caseCommonExtensionBase(baseCamelBinding);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case JpaPackage.CAMEL_JPA_BINDING_TYPE: {
                CamelJpaBindingType camelJpaBindingType = (CamelJpaBindingType)theEObject;
                T result = caseCamelJpaBindingType(camelJpaBindingType);
                if (result == null) result = caseBaseCamelBinding(camelJpaBindingType);
                if (result == null) result = caseSwitchYardBindingType(camelJpaBindingType);
                if (result == null) result = caseBinding(camelJpaBindingType);
                if (result == null) result = caseCommonExtensionBase(camelJpaBindingType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case JpaPackage.DOCUMENT_ROOT: {
                DocumentRoot documentRoot = (DocumentRoot)theEObject;
                T result = caseDocumentRoot(documentRoot);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case JpaPackage.JPA_CONSUMER_TYPE: {
                JpaConsumerType jpaConsumerType = (JpaConsumerType)theEObject;
                T result = caseJpaConsumerType(jpaConsumerType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case JpaPackage.JPA_PRODUCER_TYPE: {
                JpaProducerType jpaProducerType = (JpaProducerType)theEObject;
                T result = caseJpaProducerType(jpaProducerType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case JpaPackage.PARAMETER_TYPE: {
                ParameterType parameterType = (ParameterType)theEObject;
                T result = caseParameterType(parameterType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Additional Uri Parameters Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Additional Uri Parameters Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAdditionalUriParametersType(AdditionalUriParametersType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentRoot(DocumentRoot object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Producer Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Producer Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJpaProducerType(JpaProducerType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Parameter Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParameterType(ParameterType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Consumer Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Consumer Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJpaConsumerType(JpaConsumerType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Common Extension Base</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Common Extension Base</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCommonExtensionBase(CommonExtensionBase object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Binding</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBinding(Binding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Switch Yard Binding Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Switch Yard Binding Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSwitchYardBindingType(SwitchYardBindingType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Base Camel Binding</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Base Camel Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBaseCamelBinding(BaseCamelBinding object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Camel Jpa Binding Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Camel Jpa Binding Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCamelJpaBindingType(CamelJpaBindingType object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //JpaSwitch
