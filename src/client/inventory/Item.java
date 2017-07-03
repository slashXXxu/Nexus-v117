
package client.inventory;

import java.io.Serializable;

public class Item implements Comparable<Item>, Serializable {

    private final int id;
    private short position;
    private short quantity;
    private short flag;
    private long expiration = -1, inventoryitemid = 0;
    private MaplePet pet = null;
    private int uniqueid;
    private String owner = "";
    private String GameMaster_log = "";
    private String giftFrom = "";
    private int exp;

    public Item(final int id, final short position, final short quantity, final short flag, final int uniqueid) {
        super();
        this.id = id;
        this.position = position;
        this.quantity = quantity;
        this.flag = flag;
        this.uniqueid = uniqueid;
    }

    public Item(final int id, final short position, final short quantity, final short flag) {
        super();
        this.id = id;
        this.position = position;
        this.quantity = quantity;
        this.flag = flag;
        this.uniqueid = -1;
    }

    public Item(int id, byte position, short quantity) {
        super();
        this.id = id;
        this.position = position;
        this.quantity = quantity;
        this.uniqueid = -1;
    }

    public Item copy() {
        final Item ret = new Item(id, position, quantity, flag, uniqueid);
        ret.pet = pet;
        ret.owner = owner;
        ret.GameMaster_log = GameMaster_log;
        ret.expiration = expiration;
        ret.giftFrom = giftFrom;
        ret.exp = exp;
        return ret;
    }

    public Item copyWithQuantity(final short qq) {
        final Item ret = new Item(id, position, qq, flag, uniqueid);
        ret.pet = pet;
        ret.owner = owner;
        ret.GameMaster_log = GameMaster_log;
        ret.expiration = expiration;
        ret.giftFrom = giftFrom;
        ret.exp = exp;
        return ret;
    }

    public final int getItemId() {
        return id;
    }

    public final short getPosition() {
        return position;
    }

    public final void setPosition(final short position) {
        this.position = position;

        if (pet != null) {
            pet.setInventoryPosition(position);
        }
    }

    public final short getFlag() {
        return flag;
    }

    public final void setFlag(final short flag) {
        this.flag = flag;
    }

    public final short getQuantity() {
        return quantity;
    }

    public void setQuantity(final short quantity) {
        this.quantity = quantity;
    }

    public byte getType() {
        return 2; // An Item
    }

    public final String getOwner() {
        return owner;
    }

    public final void setOwner(final String owner) {
        this.owner = owner;
    }

    public final long getExpiration() {
        return expiration;
    }

    public final void setExpiration(final long expire) {
        this.expiration = expire;
    }

    public final String getGMLog() {
        return GameMaster_log;
    }

    public void setGMLog(final String GameMaster_log) {
        this.GameMaster_log = GameMaster_log;
    }

    public final int getUniqueId() {
        return uniqueid;
    }

    public void setUniqueId(int ui) {
        this.uniqueid = ui;
    }

    public final long getInventoryId() { // This doesn't need to be 100% accurate, just different
        return inventoryitemid;
    }

    public void setInventoryId(long ui) {
        this.inventoryitemid = ui;
    }

    public final MaplePet getPet() {
        return pet;
    }

    public final void setPet(final MaplePet pet) {
        this.pet = pet;
        if (pet != null) {
            this.uniqueid = pet.getUniqueId();
        }
    }

    public String getGiftFrom() {
        return giftFrom;
    }

    public void setGiftFrom(String gf) {
        this.giftFrom = gf;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public int compareTo(Item other) {
        if (Math.abs(position) < Math.abs(other.getPosition())) {
            return -1;
        } else if (Math.abs(position) == Math.abs(other.getPosition())) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Item)) {
            return false;
        }
        final Item ite = (Item) obj;
        return uniqueid == ite.getUniqueId() && id == ite.getItemId() && quantity == ite.getQuantity() && Math.abs(position) == Math.abs(ite.getPosition());
    }

    @Override
    public String toString() {
        return "Item: " + id + " Quantity: " + quantity;
    }
}