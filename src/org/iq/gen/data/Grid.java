package org.iq.gen.data;

import java.util.ArrayList;
import java.util.List;

public class Grid extends BaseData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7317336776719305844L;

	private List<GridRow> rows;

	/**
	 * @return the rows
	 */
	public List<GridRow> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(List<GridRow> rows) {
		this.rows = rows;
	}

	/**
	 * @param row
	 *            the row to add
	 */
	public void addRow(GridRow row) {
		if (this.rows == null) {
			this.rows = new ArrayList<GridRow>();
		}
		this.rows.add(row);
	}

	/**
	 * @param rows
	 *            the rows to add
	 */
	public void addRows(List<GridRow> rows) {
		if (this.rows == null) {
			this.rows = new ArrayList<GridRow>();
		}
		this.rows.addAll(rows);
	}

	/**
	 * @author Sam
	 *
	 */
	public class GridRow extends BaseData {

		/**
		 * 
		 */
		private static final long serialVersionUID = -5532843744300257023L;

		private List<GridColumn> cols;

		/**
		 * @return the cols
		 */
		public List<GridColumn> getCols() {
			return cols;
		}

		/**
		 * @param cols
		 *            the cols to set
		 */
		public void setCols(List<GridColumn> cols) {
			this.cols = cols;
		}

		/**
		 * @param col
		 *            the col to add
		 */
		public void addCol(GridColumn col) {
			if (this.cols == null) {
				this.cols = new ArrayList<GridColumn>();
			}
			this.cols.add(col);
		}

		/**
		 * @param cols
		 *            the cols to add
		 */
		public void addCols(List<GridColumn> cols) {
			if (this.cols == null) {
				this.cols = new ArrayList<GridColumn>();
			}
			this.cols.addAll(cols);
		}

		/**
		 * @author Sam
		 *
		 */
		public class GridColumn extends BaseData {

			/**
			 * 
			 */
			private static final long serialVersionUID = 9032298160149269496L;

			private int xsColumnWidth;
			private int smColumnWidth;
			private int mdColumnWidth;
			private int lgColumnWidth;

			private int xsOffset;
			private int smOffset;
			private int mdOffset;
			private int lgOffset;

			private int xsPush;
			private int smPush;
			private int mdPush;
			private int lgPush;

			private int xsPull;
			private int smPull;
			private int mdPull;
			private int lgPull;

			/**
			 * @return the xsColumnWidth
			 */
			public int getXsColumnWidth() {
				return xsColumnWidth;
			}

			/**
			 * @param xsColumnWidth
			 *            the xsColumnWidth to set
			 */
			public void setXsColumnWidth(int xsColumnWidth) {
				this.xsColumnWidth = xsColumnWidth;
			}

			/**
			 * @return the smColumnWidth
			 */
			public int getSmColumnWidth() {
				return smColumnWidth;
			}

			/**
			 * @param smColumnWidth
			 *            the smColumnWidth to set
			 */
			public void setSmColumnWidth(int smColumnWidth) {
				this.smColumnWidth = smColumnWidth;
			}

			/**
			 * @return the mdColumnWidth
			 */
			public int getMdColumnWidth() {
				return mdColumnWidth;
			}

			/**
			 * @param mdColumnWidth
			 *            the mdColumnWidth to set
			 */
			public void setMdColumnWidth(int mdColumnWidth) {
				this.mdColumnWidth = mdColumnWidth;
			}

			/**
			 * @return the lgColumnWidth
			 */
			public int getLgColumnWidth() {
				return lgColumnWidth;
			}

			/**
			 * @param lgColumnWidth
			 *            the lgColumnWidth to set
			 */
			public void setLgColumnWidth(int lgColumnWidth) {
				this.lgColumnWidth = lgColumnWidth;
			}

			/**
			 * @return the xsOffset
			 */
			public int getXsOffset() {
				return xsOffset;
			}

			/**
			 * @param xsOffset
			 *            the xsOffset to set
			 */
			public void setXsOffset(int xsOffset) {
				this.xsOffset = xsOffset;
			}

			/**
			 * @return the smOffset
			 */
			public int getSmOffset() {
				return smOffset;
			}

			/**
			 * @param smOffset
			 *            the smOffset to set
			 */
			public void setSmOffset(int smOffset) {
				this.smOffset = smOffset;
			}

			/**
			 * @return the mdOffset
			 */
			public int getMdOffset() {
				return mdOffset;
			}

			/**
			 * @param mdOffset
			 *            the mdOffset to set
			 */
			public void setMdOffset(int mdOffset) {
				this.mdOffset = mdOffset;
			}

			/**
			 * @return the lgOffset
			 */
			public int getLgOffset() {
				return lgOffset;
			}

			/**
			 * @param lgOffset
			 *            the lgOffset to set
			 */
			public void setLgOffset(int lgOffset) {
				this.lgOffset = lgOffset;
			}

			/**
			 * @return the xsPush
			 */
			public int getXsPush() {
				return xsPush;
			}

			/**
			 * @param xsPush
			 *            the xsPush to set
			 */
			public void setXsPush(int xsPush) {
				this.xsPush = xsPush;
			}

			/**
			 * @return the smPush
			 */
			public int getSmPush() {
				return smPush;
			}

			/**
			 * @param smPush
			 *            the smPush to set
			 */
			public void setSmPush(int smPush) {
				this.smPush = smPush;
			}

			/**
			 * @return the mdPush
			 */
			public int getMdPush() {
				return mdPush;
			}

			/**
			 * @param mdPush
			 *            the mdPush to set
			 */
			public void setMdPush(int mdPush) {
				this.mdPush = mdPush;
			}

			/**
			 * @return the lgPush
			 */
			public int getLgPush() {
				return lgPush;
			}

			/**
			 * @param lgPush
			 *            the lgPush to set
			 */
			public void setLgPush(int lgPush) {
				this.lgPush = lgPush;
			}

			/**
			 * @return the xsPull
			 */
			public int getXsPull() {
				return xsPull;
			}

			/**
			 * @param xsPull
			 *            the xsPull to set
			 */
			public void setXsPull(int xsPull) {
				this.xsPull = xsPull;
			}

			/**
			 * @return the smPull
			 */
			public int getSmPull() {
				return smPull;
			}

			/**
			 * @param smPull
			 *            the smPull to set
			 */
			public void setSmPull(int smPull) {
				this.smPull = smPull;
			}

			/**
			 * @return the mdPull
			 */
			public int getMdPull() {
				return mdPull;
			}

			/**
			 * @param mdPull
			 *            the mdPull to set
			 */
			public void setMdPull(int mdPull) {
				this.mdPull = mdPull;
			}

			/**
			 * @return the lgPull
			 */
			public int getLgPull() {
				return lgPull;
			}

			/**
			 * @param lgPull
			 *            the lgPull to set
			 */
			public void setLgPull(int lgPull) {
				this.lgPull = lgPull;
			}
		}
	}
}