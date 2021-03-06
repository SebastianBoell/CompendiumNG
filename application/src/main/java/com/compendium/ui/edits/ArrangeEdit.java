/********************************************************************************
 *                                                                              *
 *  (c) Copyright 2010 Verizon Communications USA and The Open University UK    *
 *                                                                              *
 *  This software is freely distributed in accordance with                      *
 *  the GNU Lesser General Public (LGPL) license, version 3 or later            *
 *  as published by the Free Software Foundation.                               *
 *  For details see LGPL: http://www.fsf.org/licensing/licenses/lgpl.html       *
 *               and GPL: http://www.fsf.org/licensing/licenses/gpl-3.0.html    *
 *                                                                              *
 *  This software is provided by the copyright holders and contributors "as is" *
 *  and any express or implied warranties, including, but not limited to, the   *
 *  implied warranties of merchantability and fitness for a particular purpose  *
 *  are disclaimed. In no event shall the copyright owner or contributors be    *
 *  liable for any direct, indirect, incidental, special, exemplary, or         *
 *  consequential damages (including, but not limited to, procurement of        *
 *  substitute goods or services; loss of use, data, or profits; or business    *
 *  interruption) however caused and on any theory of liability, whether in     *
 *  contract, strict liability, or tort (including negligence or otherwise)     *
 *  arising in any way out of the use of this software, even if advised of the  *
 *  possibility of such damage.                                                 *
 *                                                                              *
 ********************************************************************************/

package com.compendium.ui.edits;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.compendium.LanguageProperties;
import com.compendium.ui.IUIArrange;
import com.compendium.ui.UIViewFrame;

/**
 * This class holds the data for an arrange, so it can be undone/redone.
 * @author ? / Michelle Bachler
 */
public class ArrangeEdit extends PCEdit {

	/** The IUIArrange object that holds the required data to do and undo the arrange.*/
	private IUIArrange arrange = null;


	/**
	 * The constructor.
	 * @param viewFrame com.compendium.ui.UIViewFrame, the frame for the view being arranged.
	 */
	public ArrangeEdit (UIViewFrame viewFrame) {
		super(viewFrame);
	}

	/**
	 * Undoes the last edit operation of this type.
	 *
     * @exception CannotUndoException if <code>canUndo</code> returns <code>false</code>
     * @see	#canUndo
 	 */
	public void undo() throws CannotUndoException {
		arrange.undoArrange(oViewFrame);
	}

	/**
     * Redoes the previous edit of this type.
     *
     * @exception CannotRedoException if <code>canRedo</code> returns <code>false</code>
     * @see	#canRedo
 	 */
	public void redo() throws CannotRedoException {
		arrange.redoArrange(oViewFrame);
	}

    /**
     * Returns true if this edit is <code>alive</code>
     * and <code>hasBeenDone</code> is <code>true</code>.
	 * HERE: always return true.
     *
     * @return true if this edit is <code>alive</code> and <code>hasBeenDone</code> is <code>true</code>
     *
     * @see	#undo
     * @see	#redo
     */
	public boolean canUndo() { return true; }

    /**
     * Returns <code>true</code> if this edit is <code>alive</code>
     * and <code>hasBeenDone</code> is <code>false</code>.
	 * HERE: always return true.
     *
     * @return <code>true</code> if this edit is <code>alive</code> and <code>hasBeenDone</code> is <code>false</code>
	 *
     * @see	#undo
     * @see	#redo
     */
	public boolean canRedo() { return true; }

    /**
     *  Used by <code>getUndoPresentationName</code> and <code>getRedoPresentationName</code> to
     *  construct the strings they return.
     *
     *	@return the presentation name for this edit.
     */
	public String getPresentationName() { return LanguageProperties.getString(LanguageProperties.EDITS_BUNDLE, "ArrangeEdit.arrange"); } //$NON-NLS-1$

	/**
	 * Set the UIArrange object that holds the data for the arrange on the View.
	 * @param a com.compendium.ui.UIArrange, the object that holds the data for the arrange on the View.
	 */
	public void setArrange(IUIArrange a) {
		arrange = a;
	}
}
