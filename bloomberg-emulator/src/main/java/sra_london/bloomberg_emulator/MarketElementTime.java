//------------------------------------------------------------------------------
// <copyright project="BEmu_maven" file="/BEmu_maven/bemu/src/main/java/com/bloomberglp/blpapi/MarketElementTime.java" company="Jordan Robinson">
//     Copyright (c) 2013 Jordan Robinson. All rights reserved.
//
//     The use of this software is governed by the Microsoft Public License
//     which is included with this distribution.
// </copyright>
//------------------------------------------------------------------------------

package sra_london.bloomberg_emulator;

import sra_london.bloomberg_emulator.Datetime;
import sra_london.bloomberg_emulator.DateTimeTypeEnum;
import sra_london.bloomberg_emulator.Name;
import sra_london.bloomberg_emulator.Schema;

public class MarketElementTime extends Element
{
	private final Datetime _date;
	private final String _name;
	
	MarketElementTime(String name, Datetime date)
    {
		this._date = new Datetime(date, DateTimeTypeEnum.time);		
        this._name = name;
    }
	
    public Name name() throws Exception
    {
    	return new Name(this._name);
    }
    
    public int numValues()
    {
    	return 1;
    }
    
    public int numElements()
    {
    	return 0;
    }
    
    public boolean isComplexType()
    {
    	return false;
    }
    
    public boolean isArray()
    {
    	return false;
    }
    
    public boolean isNull()
    {
    	return false;
    }

    public Schema.Datatype datatype()
    {
    	return Schema.Datatype.TIME;
    }
    
    protected StringBuilder prettyPrint(int tabIndent) throws Exception
    {
    	String strDate = sra_london.bloomberg_emulator.DisplayFormats.MarketDataRequests_FormatDateZone(this._date);
    	return super.prettyPrintHelper(tabIndent, strDate);
    }
    
    public Object getValue()
    {
    	return this._date;
    }

    public Datetime getValueAsTime()
    {
        return this._date;
    }
}
