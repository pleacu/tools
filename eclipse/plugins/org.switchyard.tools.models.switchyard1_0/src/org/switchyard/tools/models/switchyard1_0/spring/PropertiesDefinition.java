/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.switchyard.tools.models.switchyard1_0.spring;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Properties Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.switchyard.tools.models.switchyard1_0.spring.PropertiesDefinition#getProperty <em>Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.switchyard.tools.models.switchyard1_0.spring.SpringPackage#getPropertiesDefinition()
 * @model extendedMetaData="name='propertiesDefinition' kind='elementOnly'"
 * @generated
 */
public interface PropertiesDefinition extends EObject {
	/**
     * Returns the value of the '<em><b>Property</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Property</em>' containment reference list.
     * @see org.switchyard.tools.models.switchyard1_0.spring.SpringPackage#getPropertiesDefinition_Property()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace'"
     * @generated
     */
	EList<EObject> getProperty();

} // PropertiesDefinition
