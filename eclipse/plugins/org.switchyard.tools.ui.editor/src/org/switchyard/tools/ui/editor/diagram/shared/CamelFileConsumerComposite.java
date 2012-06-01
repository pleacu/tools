/******************************************************************************* 
 * Copyright (c) 2012 Red Hat, Inc. 
 *  All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 *
 * @author bfitzpat
 ******************************************************************************/
package org.switchyard.tools.ui.editor.diagram.shared;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.soa.sca.sca1_1.model.sca.Binding;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.switchyard.tools.models.switchyard1_0.camel.CamelFactory;
import org.switchyard.tools.models.switchyard1_0.camel.CamelFileBindingType;
import org.switchyard.tools.ui.editor.impl.SwitchyardSCAEditor;

/**
 * @author bfitzpat
 * 
 */
public class CamelFileConsumerComposite extends AbstractSwitchyardComposite implements IBindingComposite {

    private Composite _panel;
    private CamelFileBindingType _binding = null;
    private boolean _inUpdate = false;
    private Text _directoryText;
    private Text _fileNameText;
    private Button _autoCreateButton;
    private Text _includeText;
    private Text _excludeText;
    private Text _preMoveText;
    private Text _moveText;
    private Text _moveFailedText;
    private Text _maxMessagesPerPollText;
    private Text _delayText;

    @Override
    public Binding getBinding() {
        return this._binding;
    }

    @Override
    public void setBinding(Binding impl) {
        if (impl instanceof CamelFileBindingType) {
            this._binding = (CamelFileBindingType) impl;
            _inUpdate = true;
            if (this._binding.getConsume() != null) {
                if (this._binding.getConsume().getDelay() != null) {
                    _delayText.setText(this._binding.getConsume().getDelay().toString());
                }
                if (this._binding.getConsume().getMaxMessagesPerPoll() != null) {
                    _maxMessagesPerPollText.setText(this._binding.getConsume().getMaxMessagesPerPoll().toString());
                }
                if (this._binding.getConsume().getExclude() != null) {
                    _excludeText.setText(this._binding.getConsume().getExclude());
                }
                if (this._binding.getConsume().getInclude() != null) {
                    _includeText.setText(this._binding.getConsume().getInclude());
                }
                if (this._binding.getConsume().getMoveFailed() != null) {
                    _moveFailedText.setText(this._binding.getConsume().getMoveFailed());
                }
                if (this._binding.getConsume().getMove() != null) {
                    _moveText.setText(this._binding.getConsume().getMove());
                }
                if (this._binding.getConsume().getPreMove() != null) {
                    _preMoveText.setText(this._binding.getConsume().getPreMove());
                }
            }
            if (this._binding.getDirectory() != null) {
                _directoryText.setText(this._binding.getDirectory());
            }
            if (this._binding.getFileName() != null) {
                _fileNameText.setText(this._binding.getFileName());
            }
            if (this._binding.isAutoCreate()) {
                _autoCreateButton.setSelection(this._binding.isAutoCreate());
            }
            _inUpdate = false;
            validate();
        } else {
            this._binding = null;
        }
    }

    @Override
    protected void validate() {
        setErrorMessage(null);
        if (getBinding() != null) {
            if (_directoryText.getText().trim().isEmpty()) {
                setErrorMessage("Directory may not be empty.");
            } else if (!_delayText.getText().trim().isEmpty()) {
                try {
                    new BigInteger(_delayText.getText().trim());
                } catch (NumberFormatException nfe) {
                    setErrorMessage("Delay value must be a valid number.");
                }
            } else if (!_maxMessagesPerPollText.getText().trim().isEmpty()) {
                try {
                    new BigInteger(_maxMessagesPerPollText.getText().trim());
                } catch (NumberFormatException nfe) {
                    setErrorMessage("Max Messages per Poll value must be a valid number.");
                }
            }
        }
    }

    @Override
    public void createContents(Composite parent, int style) {
        _panel = new Composite(parent, style);
        _panel.setLayout(new FillLayout());
        if (getRootGridData() != null) {
            _panel.setLayoutData(getRootGridData());
        }

        TabFolder tabFolder = new TabFolder(_panel, SWT.NONE);

        TabItem one = new TabItem(tabFolder, SWT.NONE);
        one.setText("Consumer");
        one.setControl(getConsumerTabControl(tabFolder));
    }

    private Control getConsumerTabControl(TabFolder tabFolder) {
        Composite composite = new Composite(tabFolder, SWT.NONE);
        GridLayout gl = new GridLayout(1, false);
        composite.setLayout(gl);

        Group fileGroup = new Group(composite, SWT.NONE);
        fileGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        fileGroup.setLayout(new GridLayout(2, false));
        fileGroup.setText("File and Directory Options");

        _directoryText = createLabelAndText(fileGroup, "Directory*");
        _fileNameText = createLabelAndText(fileGroup, "File Name");

        _autoCreateButton = createCheckbox(fileGroup, "Auto Create Missing Directories in File Path");
        _includeText = createLabelAndText(fileGroup, "Include");
        _excludeText = createLabelAndText(fileGroup, "Exclude");

        Group moveGroup = new Group(composite, SWT.NONE);
        moveGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        moveGroup.setLayout(new GridLayout(2, false));
        moveGroup.setText("Move Options");

        _preMoveText = createLabelAndText(moveGroup, "Pre-Move");
        _moveText = createLabelAndText(moveGroup, "Move (Default .camel)");
        _moveFailedText = createLabelAndText(moveGroup, "Move Failed");

        Group pollGroup = new Group(composite, SWT.NONE);
        pollGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        pollGroup.setLayout(new GridLayout(2, false));
        pollGroup.setText("Poll Options");

        _maxMessagesPerPollText = createLabelAndText(pollGroup, "Max Messages Per Poll (Default 0)");
        _delayText = createLabelAndText(pollGroup, "Delay Between Polls (MS) (Default 500)");

        return composite;
    }

    @Override
    public Composite getPanel() {
        return this._panel;
    }

    /**
     * @param parent parent composite
     * @param label string to put in label
     * @return reference to created Text control
     */
    protected Text createLabelAndText(Composite parent, String label) {
        Text newText = super.createLabelAndText(parent, label);
        newText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (!_inUpdate) {
                    validate();
                    handleModify((Control) e.getSource());
                    fireChangedEvent((Control) e.getSource());
                }
            }
        });
        return newText;
    }

    /**
     * @param parent parent composite
     * @param label string for label
     * @return reference to created Button
     */
    protected Button createCheckbox(Composite parent, String label) {
        Button newButton = super.createCheckbox(parent, label);
        newButton.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (!_inUpdate) {
                    handleModify((Control) e.getSource());
                    validate();
                    fireChangedEvent((Control) e.getSource());
                }
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                widgetSelected(e);
            }
        });
        return newButton;
    }

    private class ConsumeRecordingCommand extends RecordingCommand {
        
        private CamelFileBindingType _innerBinding;
        private String _featureId;
        private Object _value;

        public ConsumeRecordingCommand(TransactionalEditingDomain domain, CamelFileBindingType binding, String featureId,
                Object value) {
            super(domain);
            this._innerBinding = binding;
            this._featureId = featureId;
            this._value = value;
        }

        @Override
        protected void doExecute() {
            if (_innerBinding.getConsume() == null) {
                _innerBinding.setConsume(CamelFactory.eINSTANCE.createFileConsumerType());
            }
            setFeatureValue(_innerBinding.getConsume(), _featureId, _value);
        }

    }

    private void setFeatureValue(EObject eObject, String featureId, Object value) {
        EClass eClass = eObject.eClass();
        for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {
            EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
            if (eStructuralFeature.isChangeable()) {
                if (eStructuralFeature.getName().equalsIgnoreCase(featureId)) {
                    eObject.eSet(eStructuralFeature, value);
                    break;
                }
            }
        }
    }

    private class BindingRecordingCommand extends RecordingCommand {
        
        private CamelFileBindingType _innerBinding;
        private String _featureId;
        private Object _value;

        public BindingRecordingCommand(TransactionalEditingDomain domain, CamelFileBindingType binding, String featureId,
                Object value) {
            super(domain);
            this._innerBinding = binding;
            this._featureId = featureId;
            this._value = value;
        }

        @Override
        protected void doExecute() {
            setFeatureValue(_innerBinding, _featureId, _value);
        }

    }

    @SuppressWarnings("restriction")
    private void handleModify(final Control control) {
        TransactionalEditingDomain domain = null;
        if (_binding.eContainer() != null) {
            domain = SwitchyardSCAEditor.getActiveEditor().getEditingDomain();
        }
        if (control.equals(_directoryText)) {
            if (domain != null) {
                BindingRecordingCommand command = new BindingRecordingCommand(
                        domain, _binding, "directory", _directoryText.getText().trim());
                domain.getCommandStack().execute(command);
            } else {
                _binding.setDirectory(_directoryText.getText().trim());
            }
        } else if (control.equals(_fileNameText)) {
            if (domain != null) {
                BindingRecordingCommand command = new BindingRecordingCommand(
                        domain, _binding, "fileName", _fileNameText.getText().trim());
                domain.getCommandStack().execute(command);
            } else {
                _binding.setFileName(_fileNameText.getText().trim());
            }
        } else if (control.equals(_autoCreateButton)) {
            if (domain != null) {
                BindingRecordingCommand command = new BindingRecordingCommand(
                        domain, _binding, "autoCreate", new Boolean(_autoCreateButton.getSelection()));
                domain.getCommandStack().execute(command);
            } else {
                _binding.setAutoCreate(_autoCreateButton.getSelection());
            }
        } else if (control.equals(_delayText)) {
            if (domain != null) {
                try {
                    ConsumeRecordingCommand command = new ConsumeRecordingCommand(
                        domain, _binding, "delay", new BigInteger(_delayText.getText().trim()));
                    domain.getCommandStack().execute(command);
                } catch (NumberFormatException nfe) {
                    // do nothing
                    nfe.fillInStackTrace();
                }
            } else {
                if (_binding.getConsume() == null) {
                    _binding.setConsume(CamelFactory.eINSTANCE.createFileConsumerType());
                }
                try {
                    _binding.getConsume().setDelay(new BigInteger(_delayText.getText().trim()));
                } catch (NumberFormatException nfe) {
                    // do nothing
                    nfe.fillInStackTrace();
                }
            }
        } else if (control.equals(_excludeText)) {
            if (domain != null) {
                ConsumeRecordingCommand command = new ConsumeRecordingCommand(
                        domain, _binding, "exclude", _excludeText.getText().trim());
                domain.getCommandStack().execute(command);
            } else {
                if (_binding.getConsume() == null) {
                    _binding.setConsume(CamelFactory.eINSTANCE.createFileConsumerType());
                }
                _binding.getConsume().setExclude(_excludeText.getText().trim());
            }
        } else if (control.equals(_includeText)) {
            if (domain != null) {
                ConsumeRecordingCommand command = new ConsumeRecordingCommand(
                        domain, _binding, "include", _includeText.getText().trim());
                domain.getCommandStack().execute(command);
            } else {
                if (_binding.getConsume() == null) {
                    _binding.setConsume(CamelFactory.eINSTANCE.createFileConsumerType());
                }
                _binding.getConsume().setInclude(_includeText.getText().trim());
            }
        } else if (control.equals(_maxMessagesPerPollText)) {
            if (domain != null) {
                try {
                    BindingRecordingCommand command = new BindingRecordingCommand(
                            domain, _binding, "maxMessagesPerPoll", 
                            new BigInteger(_maxMessagesPerPollText.getText().trim()));
                    domain.getCommandStack().execute(command);
                } catch (NumberFormatException nfe) {
                    nfe.fillInStackTrace();
                }
            } else {
                if (_binding.getConsume() == null) {
                    _binding.setConsume(CamelFactory.eINSTANCE.createFileConsumerType());
                }
                try {
                    _binding.getConsume().setMaxMessagesPerPoll(new BigInteger(_maxMessagesPerPollText.getText().trim()));
                } catch (NumberFormatException nfe) {
                    // do nothing
                    nfe.fillInStackTrace();
                }
            }
        } else if (control.equals(_moveFailedText)) {
            if (domain != null) {
                ConsumeRecordingCommand command = new ConsumeRecordingCommand(
                        domain, _binding, "moveFailed", _moveFailedText.getText().trim());
                domain.getCommandStack().execute(command);
            } else {
                if (_binding.getConsume() == null) {
                    _binding.setConsume(CamelFactory.eINSTANCE.createFileConsumerType());
                }
                _binding.getConsume().setMoveFailed(_moveFailedText.getText().trim());
            }
        } else if (control.equals(_moveText)) {
            if (domain != null) {
                ConsumeRecordingCommand command = new ConsumeRecordingCommand(
                        domain, _binding, "move", _moveFailedText.getText().trim());
                domain.getCommandStack().execute(command);
            } else {
                if (_binding.getConsume() == null) {
                    _binding.setConsume(CamelFactory.eINSTANCE.createFileConsumerType());
                }
                _binding.getConsume().setMove(_moveText.getText().trim());
            }
        } else if (control.equals(_preMoveText)) {
            if (domain != null) {
                ConsumeRecordingCommand command = new ConsumeRecordingCommand(
                        domain, _binding, "preMove", _preMoveText.getText().trim());
                domain.getCommandStack().execute(command);
            } else {
                if (_binding.getConsume() == null) {
                    _binding.setConsume(CamelFactory.eINSTANCE.createFileConsumerType());
                }
                _binding.getConsume().setPreMove(_preMoveText.getText().trim());
            }

        }
    }
}