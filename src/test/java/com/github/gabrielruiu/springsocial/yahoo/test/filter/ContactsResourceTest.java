package com.github.gabrielruiu.springsocial.yahoo.test.filter;

import com.github.gabrielruiu.springsocial.yahoo.module.AddressField;
import com.github.gabrielruiu.springsocial.yahoo.module.Category;
import com.github.gabrielruiu.springsocial.yahoo.module.Contacts;
import com.github.gabrielruiu.springsocial.yahoo.module.DateField;
import com.github.gabrielruiu.springsocial.yahoo.module.Field;
import com.github.gabrielruiu.springsocial.yahoo.module.FieldFlag;
import com.github.gabrielruiu.springsocial.yahoo.module.FieldType;
import com.github.gabrielruiu.springsocial.yahoo.module.NameField;
import com.github.gabrielruiu.springsocial.yahoo.module.SingleFieldValue;
import com.github.gabrielruiu.springsocial.yahoo.module.SingleValueField;
import org.junit.Before;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author Gabriel Mihai Ruiu (gabriel.ruiu@mail.com)
 */
public class ContactsResourceTest extends ContactsTemplateTest {

	@Before
	public void setup() {
		stubFor(get(urlEqualTo("/contacts?format=json"))
				.willReturn(successfulJsonResponse("homer.json")));
	}

	@Test
	public void shouldDeserializeNameIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.NAME);
		assertThat(field, notNullValue());

		NameField name = (NameField) field; 
		assertThat(name, notNullValue());
		assertThat(name.getValue().getGivenName(), is("Homer"));
		assertThat(name.getValue().getFamilyName(), is("Simpson"));
		assertThat(name.getValue().getMiddleName(), is("Jay"));
		assertThat(name.getValue().getFamilyNameSound(), is("Simpson"));
		assertThat(name.getValue().getGivenNameSound(), is("Homer"));
		assertThat(name.getValue().getPrefix(), is("none"));
		assertThat(name.getValue().getSuffix(), is("none"));

		assertThat(name.getId(), is(113));
		assertThat(name.getType(), is(FieldType.NAME));
		assertThat(name.getCreated().toString(), is("Sun Oct 19 17:46:22 CEST 2008"));
		assertThat(name.getUpdated().toString(), is("Sun Oct 19 17:46:22 CEST 2008"));
		assertThat(name.getFlags(), hasItem(FieldFlag.WORK));
	}

	@Test
	public void shouldDeserializeYahooIdIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.YAHOOID);
		assertThat(field, notNullValue());

		SingleValueField yahooId = (SingleValueField) field;
		assertThat(yahooId.getId(), is(114));
		assertThat(yahooId.getType(), is(FieldType.YAHOOID));
		assertThat(((SingleFieldValue) yahooId.getValue()).getValue(), is("homersimpson"));
		assertThat(yahooId.getCreated().toString(), is("Sun Oct 19 17:46:22 CEST 2008"));
		assertThat(yahooId.getUpdated().toString(), is("Sun Oct 19 17:46:22 CEST 2008"));
	}

	@Test
	public void shouldDeserializeGuidIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.GUID);
		assertThat(field, notNullValue());

		SingleValueField guid = (SingleValueField) field;
		assertThat(guid.getId(), is(115));
		assertThat(guid.getType(), is(FieldType.GUID));
		assertThat(((SingleFieldValue) guid.getValue()).getValue(), is("homers-guid"));
		assertThat(guid.getCreated().toString(), is("Sun Dec 07 21:28:27 CET 2014"));
		assertThat(guid.getUpdated().toString(), is("Sun Dec 07 21:28:27 CET 2014"));
	}

	@Test
	public void shouldDeserializeNicknameIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.NICKNAME);
		assertThat(field, notNullValue());

		SingleValueField nickname = (SingleValueField) field;
		assertThat(nickname.getId(), is(116));
		assertThat(nickname.getType(), is(FieldType.NICKNAME));
		assertThat(((SingleFieldValue) nickname.getValue()).getValue(), is("Home-boy"));
		assertThat(nickname.getCreated().toString(), is("Mon Oct 05 21:46:48 CEST 2009"));
		assertThat(nickname.getUpdated().toString(), is("Mon Oct 05 21:46:48 CEST 2009"));
	}

	@Test
	public void shouldDeserializeEmailIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.EMAIL);
		assertThat(field, notNullValue());

		SingleValueField email = (SingleValueField) field;
		assertThat(email.getId(), is(117));
		assertThat(email.getType(), is(FieldType.EMAIL));
		assertThat(((SingleFieldValue) email.getValue()).getValue(), is("chunkylover53@aol.com"));
		assertThat(email.getCreated().toString(), is("Sun Oct 25 20:36:58 CET 2015"));
		assertThat(email.getUpdated().toString(), is("Sun Oct 25 20:36:58 CET 2015"));
	}

	@Test
	public void shouldDeserializeOtherIdIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.OTHERID);
		assertThat(field, notNullValue());

		SingleValueField otherId = (SingleValueField) field;
		assertThat(otherId.getId(), is(118));
		assertThat(otherId.getFlags(), hasItems(FieldFlag.GOOGLE));
		assertThat(otherId.getType(), is(FieldType.OTHERID));
		assertThat(((SingleFieldValue) otherId.getValue()).getValue(), is("homey_cool"));
		assertThat(otherId.getCreated().toString(), is("Fri Apr 27 17:15:59 CEST 2007"));
		assertThat(otherId.getUpdated().toString(), is("Fri Apr 27 17:15:59 CEST 2007"));
	}

	@Test
	public void shouldDeserializePhoneIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.PHONE);
		assertThat(field, notNullValue());

		SingleValueField phone = (SingleValueField) field;
		assertThat(phone.getId(), is(119));
		assertThat(phone.getFlags(), hasItems(FieldFlag.WORK));
		assertThat(phone.getType(), is(FieldType.PHONE));
		assertThat(((SingleFieldValue) phone.getValue()).getValue(), is("(408) 555-5555"));
		assertThat(phone.getCreated().toString(), is("Fri Oct 02 08:21:49 CEST 2015"));
		assertThat(phone.getUpdated().toString(), is("Sun Oct 04 08:27:34 CEST 2015"));
	}

	@Test
	public void shouldDeserializeJobTitleIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.JOBTITLE);
		assertThat(field, notNullValue());

		SingleValueField jobTitle = (SingleValueField) field;
		assertThat(jobTitle.getId(), is(120));
		assertThat(jobTitle.getType(), is(FieldType.JOBTITLE));
		assertThat(((SingleFieldValue) jobTitle.getValue()).getValue(), is("Nuclear safety inspector"));
		assertThat(jobTitle.getCreated().toString(), is("Wed Dec 03 19:34:34 CET 2014"));
		assertThat(jobTitle.getUpdated().toString(), is("Wed Dec 03 19:34:34 CET 2014"));
	}

	@Test
	public void shouldDeserializeCompanyIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.COMPANY);
		assertThat(field, notNullValue());

		SingleValueField company = (SingleValueField) field;
		assertThat(company.getId(), is(121));
		assertThat(company.getType(), is(FieldType.COMPANY));
		assertThat(((SingleFieldValue) company.getValue()).getValue(), is("Bethesda"));
		assertThat(company.getCreated().toString(), is("Wed Dec 03 19:34:34 CET 2014"));
		assertThat(company.getUpdated().toString(), is("Wed Dec 03 19:34:34 CET 2014"));
	}

	@Test
	public void shouldDeserializeNotesIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.NOTES);
		assertThat(field, notNullValue());

		SingleValueField notes = (SingleValueField) field;
		assertThat(notes.getId(), is(122));
		assertThat(notes.getType(), is(FieldType.NOTES));
		assertThat(((SingleFieldValue) notes.getValue()).getValue(), is("Drinks a lot of beer"));
		assertThat(notes.getCreated().toString(), is("Sat Feb 18 09:53:55 CET 2017"));
		assertThat(notes.getUpdated().toString(), is("Sat Feb 18 09:53:55 CET 2017"));
	}

	@Test
	public void shouldDeserializeLinkIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.LINK);
		assertThat(field, notNullValue());

		SingleValueField link = (SingleValueField) field;
		assertThat(link.getId(), is(123));
		assertThat(link.getType(), is(FieldType.LINK));
		assertThat(((SingleFieldValue) link.getValue()).getValue(), is("http://www.homerswebpage.com/"));
		assertThat(link.getCreated().toString(), is("Wed Dec 03 19:34:34 CET 2014"));
		assertThat(link.getUpdated().toString(), is("Wed Dec 03 19:34:34 CET 2014"));
	}

	@Test
	public void shouldDeserializeAddressIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.ADDRESS);
		assertThat(field, notNullValue());

		AddressField address = (AddressField) field;
		assertThat(address.getId(), is(124));
		assertThat(address.getType(), is(FieldType.ADDRESS));
		assertThat(address.getFlags(), hasItem(FieldFlag.HOME));
		assertThat(address.getValue().getStreet(), is("742 Evergreen Terrace"));
		assertThat(address.getValue().getStateOrProvince(), is("Springfield"));
		assertThat(address.getValue().getCity(), is("Springfield"));
		assertThat(address.getValue().getPostalCode(), is("13231"));
		assertThat(address.getValue().getCountry(), is("United States of America"));
		assertThat(address.getValue().getCountryCode(), is("USA"));
		assertThat(address.getCreated().toString(), is("Mon Dec 15 22:42:04 CET 2014"));
		assertThat(address.getUpdated().toString(), is("Mon Dec 15 22:42:04 CET 2014"));
	}

	@Test
	public void shouldDeserializeBirthdayIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.BIRTHDAY);
		assertThat(field, notNullValue());

		DateField birthday = (DateField) field;
		assertThat(birthday.getId(), is(125));
		assertThat(birthday.getType(), is(FieldType.BIRTHDAY));
		assertThat(birthday.getValue().getDay(), is(12));
		assertThat(birthday.getValue().getMonth(), is(5));
		assertThat(birthday.getValue().getYear(), is(1956));
		assertThat(birthday.getCreated().toString(), is("Sun Dec 14 22:05:36 CET 2014"));
		assertThat(birthday.getUpdated().toString(), is("Sun Dec 14 22:05:36 CET 2014"));
	}

	@Test
	public void shouldDeserializeAnniversaryIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		Field field = getField(contacts.getContact().get(0), FieldType.ANNIVERSARY);
		assertThat(field, notNullValue());

		DateField anniversary = (DateField) field;
		assertThat(anniversary.getId(), is(126));
		assertThat(anniversary.getType(), is(FieldType.ANNIVERSARY));
		assertThat(anniversary.getValue().getDay(), is(12));
		assertThat(anniversary.getValue().getMonth(), is(5));
		assertThat(anniversary.getValue().getYear(), is(1990));
		assertThat(anniversary.getCreated().toString(), is("Sun Dec 14 22:05:36 CET 2014"));
		assertThat(anniversary.getUpdated().toString(), is("Sun Dec 14 22:05:36 CET 2014"));
	}

	@Test
	public void shouldDeserializeCategoriesIntoExpectedValues() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getContact(), notNullValue());
		assertThat(contacts.getContact(), hasSize(1));

		assertThat(contacts.getContact().get(0).getCategories(), hasSize(2));
		Category firstCategory = contacts.getContact().get(0).getCategories().get(0);
		assertThat(firstCategory.getName(), is("group1"));
		assertThat(firstCategory.getId(), is(1));
		assertThat(firstCategory.getUri(), is("http://social.yahooapis.com/v1/user/my-yahoo-guid/contact/10/category/"));
		assertThat(firstCategory.getCreated().toString(), is("Fri Jan 16 11:26:56 CET 1970"));
		assertThat(firstCategory.getUpdated().toString(), is("Fri Jan 16 11:26:56 CET 1970"));
		
		Category secondCategory = contacts.getContact().get(0).getCategories().get(1);
		assertThat(secondCategory.getName(), is("group2"));
		assertThat(secondCategory.getId(), is(2));
		assertThat(secondCategory.getUri(), is("http://social.yahooapis.com/v1/user/my-yahoo-guid/contact/10/category/"));
		assertThat(secondCategory.getCreated().toString(), is("Sat Jan 17 10:53:04 CET 1970"));
		assertThat(secondCategory.getUpdated().toString(), is("Sat Jan 17 10:53:04 CET 1970"));
	}

	@Test
	public void shouldDeserializePagingParameters() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getCount(), is(1));
		assertThat(contacts.getStart(), is(0));
		assertThat(contacts.getTotal(), is(1));
	}

	@Test
	public void shouldDeserializeContactsResourceMetadata() {
		Contacts contacts = contactsTemplate().getContacts();

		assertThat(contacts, notNullValue());
		assertThat(contacts.getUri(), is("http://social.yahooapis.com/v1/user/my-yahoo-guid/contacts"));
		assertThat(contacts.getCreated().toString(), is("Sat Jan 17 10:53:04 CET 1970"));
		assertThat(contacts.getUpdated().toString(), is("Sat Jan 17 10:53:04 CET 1970"));
	}
}
