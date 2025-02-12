package edu.nku.CSC440.stagbar.dataaccess.data;

public class ReportItem {

	private Alcohol alcohol;
	private double amountCurrent;
	private double amountDelivered;
	private double amountPrevious;
	private double amountSold;
	private int bottlesCurrent;
	private int bottlesDelivered;
	private int bottlesPrevious;
	private int bottlesSold;

	/** @see ReportItemBuilder */
	public ReportItem(Alcohol alcohol) {
		if(null == alcohol) throw new IllegalArgumentException("Alcohol cannot be null.");
		this.alcohol = alcohol;
	}

	/**
	 * @param alcohol          Alcohol whose data is represented by this entry.
	 * @param amountCurrent    Amount from MOST RECENT entry, as of <b>endDate</b>, for INVENTORY.
	 * @param amountDelivered  Summation of DELIVERY entries from <b>startDate</b> to <b>endDate</b> (inclusive).
	 * @param amountPrevious   Amount from MOST RECENT entry, as of <b>startDate</b>, for INVENTORY.
	 * @param amountSold       Summation of SALES entries from <b>startDate</b> to <b>endDate</b> (inclusive).
	 * @param bottlesCurrent   Bottles from MOST RECENT entry, as of <b>endDate</b>, for INVENTORY.
	 * @param bottlesDelivered Summation of DELIVERY entries from <b>startDate</b> to endDate (inclusive).
	 * @param bottlesPrevious  Bottles from MOST RECENT entry, as of <b>startDate</b>, for INVENTORY.
	 * @param bottlesSold      Summation of SALES entries from <b>startDate</b> to <b>endDate</b> (inclusive).
	 * @see ReportItemBuilder
	 */
	public ReportItem(Alcohol alcohol, double amountCurrent, double amountDelivered, double amountPrevious, double amountSold, int bottlesCurrent, int bottlesDelivered, int bottlesPrevious, int bottlesSold) {
		this(alcohol);
		this.amountCurrent = amountCurrent;
		this.amountDelivered = amountDelivered;
		this.amountPrevious = amountPrevious;
		this.amountSold = amountSold;
		this.bottlesCurrent = bottlesCurrent;
		this.bottlesDelivered = bottlesDelivered;
		this.bottlesPrevious = bottlesPrevious;
		this.bottlesSold = bottlesSold;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ReportItem that = (ReportItem)o;

		return getAlcohol().equals(that.getAlcohol());
	}

	public Alcohol getAlcohol() {
		return alcohol;
	}

	public double getAmountCurrent() {
		return amountCurrent;
	}

	public void setAmountCurrent(double amountCurrent) {
		this.amountCurrent = amountCurrent;
	}

	public double getAmountDelivered() {
		return amountDelivered;
	}

	public void setAmountDelivered(double amountDelivered) {
		this.amountDelivered = amountDelivered;
	}

	public double getAmountPrevious() {
		return amountPrevious;
	}

	public void setAmountPrevious(double amountPrevious) {
		this.amountPrevious = amountPrevious;
	}

	public double getAmountSold() {
		return amountSold;
	}

	public void setAmountSold(double amountSold) {
		this.amountSold = amountSold;
	}

	public int getBottlesCurrent() {
		return bottlesCurrent;
	}

	public void setBottlesCurrent(int bottlesCurrent) {
		this.bottlesCurrent = bottlesCurrent;
	}

	public int getBottlesDelivered() {
		return bottlesDelivered;
	}

	public void setBottlesDelivered(int bottlesDelivered) {
		this.bottlesDelivered = bottlesDelivered;
	}

	public int getBottlesPrevious() {
		return bottlesPrevious;
	}

	public void setBottlesPrevious(int bottlesPrevious) {
		this.bottlesPrevious = bottlesPrevious;
	}

	public int getBottlesSold() {
		return bottlesSold;
	}

	public void setBottlesSold(int bottlesSold) {
		this.bottlesSold = bottlesSold;
	}

	/** Calculates discrepancy for amount. */
	public double getDiscrepency_Amount() {
		return amountPrevious - (amountCurrent - amountDelivered + amountSold);
	}

	/** Calculates discrepancy for bottles. */
	public int getDiscrepency_Bottles() {
		return bottlesPrevious - (bottlesCurrent - bottlesDelivered + bottlesSold);
	}

	@Override
	public int hashCode() {
		return getAlcohol().hashCode();
	}
}
