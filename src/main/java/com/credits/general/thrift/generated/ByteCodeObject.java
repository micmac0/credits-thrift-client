/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.credits.general.thrift.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-02-04")
public class ByteCodeObject implements org.apache.thrift.TBase<ByteCodeObject, ByteCodeObject._Fields>, java.io.Serializable, Cloneable, Comparable<ByteCodeObject> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ByteCodeObject");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField BYTE_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("byteCode", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ByteCodeObjectStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ByteCodeObjectTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String name; // required
  public @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer byteCode; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    BYTE_CODE((short)2, "byteCode");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NAME
          return NAME;
        case 2: // BYTE_CODE
          return BYTE_CODE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BYTE_CODE, new org.apache.thrift.meta_data.FieldMetaData("byteCode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ByteCodeObject.class, metaDataMap);
  }

  public ByteCodeObject() {
  }

  public ByteCodeObject(
    java.lang.String name,
    java.nio.ByteBuffer byteCode)
  {
    this();
    this.name = name;
    this.byteCode = org.apache.thrift.TBaseHelper.copyBinary(byteCode);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ByteCodeObject(ByteCodeObject other) {
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetByteCode()) {
      this.byteCode = org.apache.thrift.TBaseHelper.copyBinary(other.byteCode);
    }
  }

  public ByteCodeObject deepCopy() {
    return new ByteCodeObject(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.byteCode = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getName() {
    return this.name;
  }

  public ByteCodeObject setName(@org.apache.thrift.annotation.Nullable java.lang.String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public byte[] getByteCode() {
    setByteCode(org.apache.thrift.TBaseHelper.rightSize(byteCode));
    return byteCode == null ? null : byteCode.array();
  }

  public java.nio.ByteBuffer bufferForByteCode() {
    return org.apache.thrift.TBaseHelper.copyBinary(byteCode);
  }

  public ByteCodeObject setByteCode(byte[] byteCode) {
    this.byteCode = byteCode == null ? (java.nio.ByteBuffer)null   : java.nio.ByteBuffer.wrap(byteCode.clone());
    return this;
  }

  public ByteCodeObject setByteCode(@org.apache.thrift.annotation.Nullable java.nio.ByteBuffer byteCode) {
    this.byteCode = org.apache.thrift.TBaseHelper.copyBinary(byteCode);
    return this;
  }

  public void unsetByteCode() {
    this.byteCode = null;
  }

  /** Returns true if field byteCode is set (has been assigned a value) and false otherwise */
  public boolean isSetByteCode() {
    return this.byteCode != null;
  }

  public void setByteCodeIsSet(boolean value) {
    if (!value) {
      this.byteCode = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((java.lang.String)value);
      }
      break;

    case BYTE_CODE:
      if (value == null) {
        unsetByteCode();
      } else {
        if (value instanceof byte[]) {
          setByteCode((byte[])value);
        } else {
          setByteCode((java.nio.ByteBuffer)value);
        }
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case BYTE_CODE:
      return getByteCode();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case BYTE_CODE:
      return isSetByteCode();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof ByteCodeObject)
      return this.equals((ByteCodeObject)that);
    return false;
  }

  public boolean equals(ByteCodeObject that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_byteCode = true && this.isSetByteCode();
    boolean that_present_byteCode = true && that.isSetByteCode();
    if (this_present_byteCode || that_present_byteCode) {
      if (!(this_present_byteCode && that_present_byteCode))
        return false;
      if (!this.byteCode.equals(that.byteCode))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
    if (isSetName())
      hashCode = hashCode * 8191 + name.hashCode();

    hashCode = hashCode * 8191 + ((isSetByteCode()) ? 131071 : 524287);
    if (isSetByteCode())
      hashCode = hashCode * 8191 + byteCode.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ByteCodeObject other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetByteCode()).compareTo(other.isSetByteCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetByteCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.byteCode, other.byteCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("ByteCodeObject(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("byteCode:");
    if (this.byteCode == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.byteCode, sb);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ByteCodeObjectStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ByteCodeObjectStandardScheme getScheme() {
      return new ByteCodeObjectStandardScheme();
    }
  }

  private static class ByteCodeObjectStandardScheme extends org.apache.thrift.scheme.StandardScheme<ByteCodeObject> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ByteCodeObject struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BYTE_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.byteCode = iprot.readBinary();
              struct.setByteCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ByteCodeObject struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.byteCode != null) {
        oprot.writeFieldBegin(BYTE_CODE_FIELD_DESC);
        oprot.writeBinary(struct.byteCode);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ByteCodeObjectTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ByteCodeObjectTupleScheme getScheme() {
      return new ByteCodeObjectTupleScheme();
    }
  }

  private static class ByteCodeObjectTupleScheme extends org.apache.thrift.scheme.TupleScheme<ByteCodeObject> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ByteCodeObject struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetByteCode()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetByteCode()) {
        oprot.writeBinary(struct.byteCode);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ByteCodeObject struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.byteCode = iprot.readBinary();
        struct.setByteCodeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

