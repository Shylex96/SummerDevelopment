import time
# ***************************************************************************
print(time.ctime(0))    # convert a time expressed in seconds since epoch to a readable string
#                                        epoch = when your computer thinks time began (reference point)
print(time.time())      # return current seconds since epoch
print(time.ctime(time.time())) # will get current time

print("---------------------------------------------------------------------")
# ***************************************************************************
# time.strftime(format, time_object) = formats a time_object to a string
time_object = time.localtime() # local time
time_object = time.gmtime()  # UTC time
local_time = time.strftime("%B %d %Y %H:%M:%S", time_object)
print(local_time)

# ***************************************************************************

# Spain Time:
# Dictionary (Avoid regional config):
meses_castellano = {
    'January': 'de Enero de',
    'February': 'de Febrero de',
    'March': 'de Marzo de',
    'April': 'de Abril de',
    'May': 'de Mayo de',
    'June': 'de Junio de',
    'July': 'de Julio de',
    'August': 'de Agosto de',
    'September': 'de Septiembre de',
    'October': 'de Octubre de',
    'November': 'de Noviembre de',
    'December': 'de Diciembre de'
}

current_time_object_esp = time.time()
new_time_object_esp = current_time_object_esp + 7200
time_object_utc = time.gmtime(new_time_object_esp)

esp_formatted_time = time.strftime("%d %B %Y - %H:%M:%S", time_object_utc)
for month_en, month_es in meses_castellano.items():
    esp_formatted_time = esp_formatted_time.replace(month_en, month_es)

print(esp_formatted_time)

# ***************************************************************************
# time.strptime(string_string, format) = parses a string representing time/date and returns a struct_time object
# time_string = "20 April, 2020"
# time_object = time.strptime(time_string,"%d %B, %Y")
# print(time_object)

# ***************************************************************************
# time.asctime(time_tuple) = accepts a time_object or a tuple up to 9 elements and returns a string
# (year, month, day, hours, minutes, secs, #day of the week, #day of the year, dst)
# time_tuple = (2020, 4, 20, 4, 20, 0, 0, 0, 0)
# time_string = time.asctime(time_tuple)
# print(time_string)

# ***************************************************************************
# time.asctime(time_tuple) = accepts a time_object or a tuple up to 9 elements and return seconds since epoch
# (year, month, day, hours, minutes, secs, #day of the week, #day of the year, dst)
# time_tuple = (2020, 4, 20, 4, 20, 0, 0, 0, 0)
# time_string = time.mktime(time_tuple)
# print(time_string)